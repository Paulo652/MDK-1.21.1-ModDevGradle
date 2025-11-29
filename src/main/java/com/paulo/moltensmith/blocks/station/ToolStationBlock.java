package com.paulo.moltensmith.blocks.station;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Tool Station for assembling modular weapons from parts.
 * Right-click to open assembly GUI.
 */
public class ToolStationBlock extends Block {
    // Workbench-like shape
    private static final VoxelShape TOP = Block.box(0, 12, 0, 16, 16, 16);
    private static final VoxelShape LEG_NW = Block.box(0, 0, 0, 3, 12, 3);
    private static final VoxelShape LEG_NE = Block.box(13, 0, 0, 16, 12, 3);
    private static final VoxelShape LEG_SW = Block.box(0, 0, 13, 3, 12, 16);
    private static final VoxelShape LEG_SE = Block.box(13, 0, 13, 16, 12, 16);
    private static final VoxelShape SHAPE = Shapes.or(TOP, LEG_NW, LEG_NE, LEG_SW, LEG_SE);
    
    public ToolStationBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    
    // TODO: Add right-click interaction to open GUI
    // TODO: Add assembly logic for combining parts
    // TODO: Add recipe validation
}
