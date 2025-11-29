package com.paulo.moltensmith.blocks.smeltery;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Casting table for creating small parts from molten metal.
 * Place a mold on top, pour molten metal, wait to solidify.
 */
public class CastingTableBlock extends Block {
    // Table shape: legs + top surface
    private static final VoxelShape TOP = Block.box(0, 12, 0, 16, 16, 16);
    private static final VoxelShape LEG_NW = Block.box(0, 0, 0, 3, 12, 3);
    private static final VoxelShape LEG_NE = Block.box(13, 0, 0, 16, 12, 3);
    private static final VoxelShape LEG_SW = Block.box(0, 0, 13, 3, 12, 16);
    private static final VoxelShape LEG_SE = Block.box(13, 0, 13, 16, 12, 16);
    private static final VoxelShape SHAPE = Shapes.or(TOP, LEG_NW, LEG_NE, LEG_SW, LEG_SE);
    
    public CastingTableBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    
    // TODO: Add BlockEntity for mold and fluid storage
    // TODO: Add cooling/solidification logic
    // TODO: Add interaction to place/remove molds
}
