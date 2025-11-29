package com.paulo.moltensmith.blocks.smeltery;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Transparent tank block that displays molten metal inside.
 * Shows fluid level and color based on the metal type.
 */
public class SmelteryTankBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);
    
    public SmelteryTankBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    
    // TODO: Add fluid rendering
    // TODO: Add BlockEntity to store fluid data
    // TODO: Add transparency rendering
}
