package com.paulo.moltensmith.blocks.station;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Advanced version of Tool Station.
 * Allows more modifier slots and access to advanced recipes.
 */
public class ToolForgeBlock extends Block {
    // Anvil-like shape (larger and more imposing than tool station)
    private static final VoxelShape BASE = Block.box(2, 0, 2, 14, 4, 14);
    private static final VoxelShape MIDDLE = Block.box(3, 4, 3, 13, 10, 13);
    private static final VoxelShape TOP = Block.box(0, 10, 0, 16, 16, 16);
    private static final VoxelShape SHAPE = Shapes.or(BASE, MIDDLE, TOP);
    
    public ToolForgeBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    
    // TODO: Add GUI with more slots than tool station
    // TODO: Add advanced assembly recipes
    // TODO: Add modifier application
}
