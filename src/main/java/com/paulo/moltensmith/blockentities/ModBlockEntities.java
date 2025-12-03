package com.paulo.moltensmith.blockentities;

import com.paulo.moltensmith.MoltenSmith;
import com.paulo.moltensmith.blocks.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
        DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MoltenSmith.MODID);
    
    public static final Supplier<BlockEntityType<EmberHearthBlockEntity>> EMBER_HEARTH = 
        BLOCK_ENTITIES.register("ember_hearth", () ->
            BlockEntityType.Builder.of(EmberHearthBlockEntity::new, 
                ModBlocks.EMBER_HEARTH_BED.get())
                .build(null)
        );
    
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
