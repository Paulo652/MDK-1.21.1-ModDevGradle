package com.paulo.moltensmith.blocks;

import com.paulo.moltensmith.MoltenSmith;
import com.paulo.moltensmith.blocks.smeltery.*;
import com.paulo.moltensmith.blocks.station.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Registry for all MoltenSmith blocks
 */
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(Registries.BLOCK, MoltenSmith.MODID);
    
    public static final DeferredRegister<Item> BLOCK_ITEMS = 
            DeferredRegister.create(Registries.ITEM, MoltenSmith.MODID);
    
    // ========== SMELTERY BLOCKS ==========
    
    /**
     * Smeltery Controller - Main interface block for the multiblock smeltery
     */
    public static final DeferredHolder<Block, SmelteryControllerBlock> SMELTERY_CONTROLLER = 
            registerBlockWithItem("smeltery_controller",
                    () -> new SmelteryControllerBlock(BlockBehaviour.Properties.of()
                            .strength(3.0f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)
                            .lightLevel(state -> state.getValue(SmelteryControllerBlock.LIT) ? 13 : 0)));
    
    /**
     * Smeltery Bricks - Structural walls for the smeltery
     */
    public static final DeferredHolder<Block, SmelteryBricksBlock> SMELTERY_BRICKS = 
            registerBlockWithItem("smeltery_bricks",
                    () -> new SmelteryBricksBlock(BlockBehaviour.Properties.of()
                            .strength(2.0f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)));
    
    /**
     * Smeltery Tank - Displays molten metal inside
     */
    public static final DeferredHolder<Block, SmelteryTankBlock> SMELTERY_TANK = 
            registerBlockWithItem("smeltery_tank",
                    () -> new SmelteryTankBlock(BlockBehaviour.Properties.of()
                            .strength(2.0f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.GLASS)
                            .noOcclusion()));
    
    /**
     * Smeltery Drain - Input/output for fluids
     */
    public static final DeferredHolder<Block, SmelteryDrainBlock> SMELTERY_DRAIN = 
            registerBlockWithItem("smeltery_drain",
                    () -> new SmelteryDrainBlock(BlockBehaviour.Properties.of()
                            .strength(2.0f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)));
    
    /**
     * Casting Table - For casting small parts (tool parts)
     */
    public static final DeferredHolder<Block, CastingTableBlock> CASTING_TABLE = 
            registerBlockWithItem("casting_table",
                    () -> new CastingTableBlock(BlockBehaviour.Properties.of()
                            .strength(2.0f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)
                            .noOcclusion()));
    
    /**
     * Casting Basin - For casting large items (blocks, ingots)
     */
    public static final DeferredHolder<Block, CastingBasinBlock> CASTING_BASIN = 
            registerBlockWithItem("casting_basin",
                    () -> new CastingBasinBlock(BlockBehaviour.Properties.of()
                            .strength(2.0f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)
                            .noOcclusion()));
    
    // ========== TOOL STATION BLOCKS ==========
    
    /**
     * Tool Station - For assembling modular weapons
     */
    public static final DeferredHolder<Block, ToolStationBlock> TOOL_STATION = 
            registerBlockWithItem("tool_station",
                    () -> new ToolStationBlock(BlockBehaviour.Properties.of()
                            .strength(2.5f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.WOOD)
                            .noOcclusion()));
    
    /**
     * Tool Forge - Advanced version of tool station
     */
    public static final DeferredHolder<Block, ToolForgeBlock> TOOL_FORGE = 
            registerBlockWithItem("tool_forge",
                    () -> new ToolForgeBlock(BlockBehaviour.Properties.of()
                            .strength(3.0f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.ANVIL)
                            .noOcclusion()));
    
    // ========== HEATING BLOCKS ==========
    
    /**
     * Ember Hearth Firebox - Lower part of the forge for heating metal
     */
    public static final DeferredHolder<Block, com.paulo.moltensmith.blocks.heating.EmberHearthFireboxBlock> EMBER_HEARTH_FIREBOX = 
            registerBlockWithItem("ember_hearth_firebox",
                    () -> new com.paulo.moltensmith.blocks.heating.EmberHearthFireboxBlock(BlockBehaviour.Properties.of()
                            .strength(3.5f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)
                            .lightLevel(state -> state.getValue(net.minecraft.world.level.block.state.properties.BlockStateProperties.LIT) ? 15 : 0)));
    
    /**
     * Ember Hearth Bed - Upper part where items are heated
     */
    public static final DeferredHolder<Block, com.paulo.moltensmith.blocks.heating.EmberHearthBedBlock> EMBER_HEARTH_BED = 
            registerBlockWithItem("ember_hearth_bed",
                    () -> new com.paulo.moltensmith.blocks.heating.EmberHearthBedBlock(BlockBehaviour.Properties.of()
                            .strength(3.5f, 6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)));
    
    // ========== HELPER METHODS ==========
    
    /**
     * Register a block with its corresponding item
     */
    private static <T extends Block> DeferredHolder<Block, T> registerBlockWithItem(String name, 
            java.util.function.Supplier<T> block) {
        var registeredBlock = BLOCKS.register(name, block);
        BLOCK_ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));
        return registeredBlock;
    }
}
