package com.paulo.moltensmith.blocks.heating;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Firebox - Lower part of the Ember Hearth
 * Holds fuel and can be lit/extinguished
 */
public class EmberHearthFireboxBlock extends Block {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    
    public EmberHearthFireboxBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
    
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, 
                                             BlockPos pos, Player player, 
                                             net.minecraft.world.InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            boolean isLit = state.getValue(LIT);
            
            // Si está apagado y tiene carbón/combustible -> encender
            if (!isLit && isFuel(stack)) {
                BlockState newState = state.setValue(LIT, true);
                level.setBlock(pos, newState, Block.UPDATE_ALL);
                level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, 
                              SoundSource.BLOCKS, 1.0F, 1.0F);
                
                // Debug
                System.out.println("DEBUG: Encendiendo bloque. Estado nuevo: " + newState);
                
                // Consumir 1 carbón
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                
                return ItemInteractionResult.SUCCESS;
            }
        }
        
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    
    @Override
    protected net.minecraft.world.InteractionResult useWithoutItem(BlockState state, Level level, 
                                                                   BlockPos pos, Player player, BlockHitResult hit) {
        if (!level.isClientSide) {
            boolean isLit = state.getValue(LIT);
            
            // Solo con mano vacía se puede apagar
            if (isLit) {
                BlockState newState = state.setValue(LIT, false);
                level.setBlock(pos, newState, Block.UPDATE_ALL);
                level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, 
                              SoundSource.BLOCKS, 1.0F, 1.0F);
                
                // Debug
                System.out.println("DEBUG: Apagando bloque. Estado nuevo: " + newState);
                
                return net.minecraft.world.InteractionResult.SUCCESS;
            }
        }
        
        return net.minecraft.world.InteractionResult.PASS;
    }
    
    /**
     * Check if item is valid fuel
     */
    private boolean isFuel(ItemStack stack) {
        return stack.is(Items.COAL) || 
               stack.is(Items.CHARCOAL) || 
               stack.is(Items.COAL_BLOCK) ||
               stack.is(Items.BLAZE_ROD) ||
               stack.is(Items.LAVA_BUCKET);
    }
}
