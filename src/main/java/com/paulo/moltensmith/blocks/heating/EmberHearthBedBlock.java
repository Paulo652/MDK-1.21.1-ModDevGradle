package com.paulo.moltensmith.blocks.heating;

import com.paulo.moltensmith.blockentities.EmberHearthBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

/**
 * Ember Hearth Bed - Upper block that holds and heats items
 */
public class EmberHearthBedBlock extends Block implements EntityBlock {
    
    public EmberHearthBedBlock(Properties properties) {
        super(properties.noOcclusion()); // noOcclusion for rendering items on top
    }
    
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, 
                                             Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return ItemInteractionResult.SUCCESS;
        }
        
        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof EmberHearthBlockEntity hearth)) {
            return ItemInteractionResult.FAIL;
        }
        
        // Find first empty slot
        for (int i = 0; i < 4; i++) {
            if (hearth.getItem(i).isEmpty()) {
                // Place item in slot
                ItemStack toPlace = stack.copy();
                toPlace.setCount(1);
                hearth.setItem(i, toPlace);
                
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                
                return ItemInteractionResult.SUCCESS;
            }
        }
        
        // If all slots full, remove first item
        ItemStack removed = hearth.getItem(0);
        if (!removed.isEmpty()) {
            player.addItem(removed);
            hearth.setItem(0, ItemStack.EMPTY);
            hearth.setHeatLevel(0, 0);
        }
        
        return ItemInteractionResult.SUCCESS;
    }
    
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EmberHearthBlockEntity(pos, state);
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return (lvl, pos, st, blockEntity) -> {
            if (blockEntity instanceof EmberHearthBlockEntity hearth) {
                hearth.tick();
            }
        };
    }
    
    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL; // Use model + BER for rendering
    }
}
