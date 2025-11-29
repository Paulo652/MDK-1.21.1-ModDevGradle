package com.paulo.moltensmith.blocks.smeltery;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Casting basin for creating large items (blocks, multiple ingots).
 * Holds more molten metal than the casting table.
 */
public class CastingBasinBlock extends Block {
    // Basin shape: hollow container
    private static final VoxelShape BOTTOM = Block.box(0, 0, 0, 16, 2, 16);
    private static final VoxelShape NORTH = Block.box(0, 2, 0, 16, 10, 2);
    private static final VoxelShape SOUTH = Block.box(0, 2, 14, 16, 10, 16);
    private static final VoxelShape WEST = Block.box(0, 2, 2, 2, 10, 14);
    private static final VoxelShape EAST = Block.box(14, 2, 2, 16, 10, 14);
    private static final VoxelShape SHAPE = Shapes.or(BOTTOM, NORTH, SOUTH, WEST, EAST);
    
    public CastingBasinBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    
    // TODO: Add BlockEntity for fluid storage
    // TODO: Add larger capacity than casting table
    // TODO: Add recipes for blocks and large items
}
