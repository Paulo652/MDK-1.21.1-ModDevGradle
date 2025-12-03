package com.paulo.moltensmith.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * BlockEntity for Ember Hearth Bed - Stores and heats items
 */
public class EmberHearthBlockEntity extends BlockEntity {
    private static final int MAX_ITEMS = 4; // Máximo 4 lingotes
    private NonNullList<ItemStack> items = NonNullList.withSize(MAX_ITEMS, ItemStack.EMPTY);
    private int[] heatLevels = new int[MAX_ITEMS]; // 0-100 para cada slot
    
    public EmberHearthBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EMBER_HEARTH.get(), pos, state);
    }
    
    // Get/Set items
    public NonNullList<ItemStack> getItems() {
        return items;
    }
    
    public ItemStack getItem(int slot) {
        if (slot >= 0 && slot < MAX_ITEMS) {
            return items.get(slot);
        }
        return ItemStack.EMPTY;
    }
    
    public void setItem(int slot, ItemStack stack) {
        if (slot >= 0 && slot < MAX_ITEMS) {
            items.set(slot, stack);
            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    }
    
    // Get/Set heat levels
    public int getHeatLevel(int slot) {
        if (slot >= 0 && slot < MAX_ITEMS) {
            return heatLevels[slot];
        }
        return 0;
    }
    
    public void setHeatLevel(int slot, int heat) {
        if (slot >= 0 && slot < MAX_ITEMS) {
            heatLevels[slot] = Math.max(0, Math.min(100, heat));
            setChanged();
        }
    }
    
    // Tick method to heat items when forge is lit
    public void tick() {
        if (level == null || level.isClientSide) return;
        
        // Check if the firebox below is lit
        net.minecraft.core.BlockPos below = worldPosition.below();
        net.minecraft.world.level.block.state.BlockState belowState = level.getBlockState(below);
        
        boolean isLit = false;
        if (belowState.getBlock() instanceof com.paulo.moltensmith.blocks.heating.EmberHearthFireboxBlock) {
            isLit = belowState.getValue(com.paulo.moltensmith.blocks.heating.EmberHearthFireboxBlock.LIT);
        }
        
        if (isLit) {
            // Heat up items
            for (int i = 0; i < MAX_ITEMS; i++) {
                if (!items.get(i).isEmpty() && heatLevels[i] < 100) {
                    heatLevels[i] = Math.min(100, heatLevels[i] + 1);
                    setChanged();
                }
            }
        } else {
            // Cool down items
            for (int i = 0; i < MAX_ITEMS; i++) {
                if (heatLevels[i] > 0) {
                    heatLevels[i] = Math.max(0, heatLevels[i] - 2);
                    setChanged();
                }
            }
        }
    }
    
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, items, registries);
        
        int[] heats = new int[MAX_ITEMS];
        for (int i = 0; i < MAX_ITEMS; i++) {
            heats[i] = heatLevels[i];
        }
        tag.putIntArray("HeatLevels", heats);
    }
    
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        items = NonNullList.withSize(MAX_ITEMS, ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, items, registries);
        
        if (tag.contains("HeatLevels")) {
            int[] heats = tag.getIntArray("HeatLevels");
            for (int i = 0; i < Math.min(heats.length, MAX_ITEMS); i++) {
                heatLevels[i] = heats[i];
            }
        }
    }
    
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }
    
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
