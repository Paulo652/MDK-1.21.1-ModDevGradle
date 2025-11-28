package com.paulo.moltensmith.items;

import com.paulo.moltensmith.MoltenSmith;
import com.paulo.moltensmith.items.parts.PartType;
import com.paulo.moltensmith.items.parts.ToolPart;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Registry for all MoltenSmith items
 */
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(Registries.ITEM, MoltenSmith.MODID);
    
    // ========== TOOL PARTS ==========
    
    // HEADS/BLADES
    public static final DeferredHolder<Item, ToolPart> KNIFE_BLADE = ITEMS.register("knife_blade",
            () -> new ToolPart(PartType.KNIFE_BLADE, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> SWORD_BLADE = ITEMS.register("sword_blade",
            () -> new ToolPart(PartType.SWORD_BLADE, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> KATANA_BLADE = ITEMS.register("katana_blade",
            () -> new ToolPart(PartType.KATANA_BLADE, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> SPEARHEAD = ITEMS.register("spearhead",
            () -> new ToolPart(PartType.SPEARHEAD, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> AXE_HEAD = ITEMS.register("axe_head",
            () -> new ToolPart(PartType.AXE_HEAD, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> PICKAXE_HEAD = ITEMS.register("pickaxe_head",
            () -> new ToolPart(PartType.PICKAXE_HEAD, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> SHOVEL_HEAD = ITEMS.register("shovel_head",
            () -> new ToolPart(PartType.SHOVEL_HEAD, new Item.Properties()));
    
    // HANDLES
    public static final DeferredHolder<Item, ToolPart> SHORT_HANDLE = ITEMS.register("short_handle",
            () -> new ToolPart(PartType.SHORT_HANDLE, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> MEDIUM_HANDLE = ITEMS.register("medium_handle",
            () -> new ToolPart(PartType.MEDIUM_HANDLE, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> LONG_HANDLE = ITEMS.register("long_handle",
            () -> new ToolPart(PartType.LONG_HANDLE, new Item.Properties()));
    
    // GUARDS
    public static final DeferredHolder<Item, ToolPart> SMALL_GUARD = ITEMS.register("small_guard",
            () -> new ToolPart(PartType.SMALL_GUARD, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> MEDIUM_GUARD = ITEMS.register("medium_guard",
            () -> new ToolPart(PartType.MEDIUM_GUARD, new Item.Properties()));
    
    public static final DeferredHolder<Item, ToolPart> LARGE_GUARD = ITEMS.register("large_guard",
            () -> new ToolPart(PartType.LARGE_GUARD, new Item.Properties()));
    
    // BINDINGS
    public static final DeferredHolder<Item, ToolPart> BINDING = ITEMS.register("binding",
            () -> new ToolPart(PartType.BINDING, new Item.Properties()));
    
    // POMMELS
    public static final DeferredHolder<Item, ToolPart> POMMEL = ITEMS.register("pommel",
            () -> new ToolPart(PartType.POMMEL, new Item.Properties()));
    
    // TODO: Add modular tools/weapons
    // TODO: Add molds
}
