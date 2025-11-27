package com.paulo.moltensmith.materials;

import com.paulo.moltensmith.MoltenSmith;
import net.minecraft.resources.ResourceLocation;

import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Central registry for all materials in MoltenSmith
 * Handles registration, lookup, and management of materials
 */
public class MaterialRegistry {
    private static final Map<ResourceLocation, Material> MATERIALS = new HashMap<>();
    private static boolean initialized = false;
    
    /**
     * Register a new material
     */
    public static Material register(Material material) {
        if (MATERIALS.containsKey(material.getId())) {
            MoltenSmith.LOGGER.warn("Material {} is already registered, overwriting!", material.getId());
        }
        MATERIALS.put(material.getId(), material);
        MoltenSmith.LOGGER.info("Registered material: {}", material.getId());
        return material;
    }
    
    /**
     * Get a material by its ResourceLocation ID
     */
    public static Optional<Material> get(ResourceLocation id) {
        return Optional.ofNullable(MATERIALS.get(id));
    }
    
    /**
     * Get a material by string path (assumes moltensmith namespace)
     */
    public static Optional<Material> get(String path) {
        return get(ResourceLocation.fromNamespaceAndPath(MoltenSmith.MODID, path));
    }
    
    /**
     * Get all registered materials
     */
    public static Collection<Material> getAll() {
        return MATERIALS.values();
    }
    
    /**
     * Check if a material is registered
     */
    public static boolean isRegistered(ResourceLocation id) {
        return MATERIALS.containsKey(id);
    }
    
    /**
     * Initialize and register all default materials
     * Called during mod initialization
     */
    public static void init() {
        if (initialized) {
            MoltenSmith.LOGGER.warn("MaterialRegistry already initialized!");
            return;
        }
        
        MoltenSmith.LOGGER.info("Initializing MoltenSmith materials...");
        
        // VANILLA MATERIALS - Balanced for progression
        
        // WOOD - Early game, renewable, low durability
        // *** VANILLA CRAFTEABLE - Can be crafted with normal recipes ***
        register(createMaterial("oak", "Oak Wood",
                new MaterialStats.Builder()
                        .durability(59)
                        .attackDamage(2.0f)
                        .miningSpeed(2.0f)
                        .miningLevel(0)
                        .enchantability(15)
                        .attackSpeed(0.2f)  // Lightweight, fast attacks
                        .weight(0.7f)       // Light material
                        .build(),
                new Color(150, 117, 70), MaterialType.WOOD));
        
        // STONE - Early-mid game, durable but heavy
        // *** VANILLA CRAFTEABLE - Can be crafted with normal recipes ***
        register(createMaterial("stone", "Stone",
                new MaterialStats.Builder()
                        .durability(131)
                        .attackDamage(3.0f)
                        .miningSpeed(4.0f)
                        .miningLevel(1)
                        .enchantability(5)
                        .attackSpeed(-0.1f) // Heavier, slower
                        .weight(1.3f)
                        .build(),
                new Color(128, 128, 128), MaterialType.STONE));
        
        // IRON - Mid game standard
        // *** REQUIRES SMELTERY - Must be melted and cast ***
        register(createMaterial("iron", "Iron",
                new MaterialStats.Builder()
                        .durability(250)
                        .attackDamage(4.0f)
                        .miningSpeed(6.0f)
                        .miningLevel(2)
                        .enchantability(14)
                        .attackSpeed(0.0f)  // Balanced
                        .weight(1.2f)
                        .knockback(0.5f)
                        .build(),
                new Color(200, 200, 200), MaterialType.METAL));
        
        // GOLD - High enchantability, low durability
        register(createMaterial("gold", "Gold",
                new MaterialStats.Builder()
                        .durability(32)
                        .attackDamage(2.5f)
                        .miningSpeed(12.0f)
                        .miningLevel(0)
                        .enchantability(22)  // Best enchantability
                        .attackSpeed(0.3f)   // Very fast
                        .weight(1.5f)        // Heavy but soft
                        .build(),
                new Color(255, 215, 0), MaterialType.METAL));
        
        // DIAMOND - Late game, excellent stats
        register(createMaterial("diamond", "Diamond",
                new MaterialStats.Builder()
                        .durability(1561)
                        .attackDamage(5.0f)
                        .miningSpeed(8.0f)
                        .miningLevel(3)
                        .enchantability(10)
                        .attackSpeed(0.0f)
                        .weight(1.0f)
                        .build(),
                new Color(0, 255, 255), MaterialType.CRYSTAL));
        
        // NETHERITE - End game, best overall
        register(createMaterial("netherite", "Netherite",
                new MaterialStats.Builder()
                        .durability(2031)
                        .attackDamage(6.0f)
                        .miningSpeed(9.0f)
                        .miningLevel(4)
                        .enchantability(15)
                        .attackSpeed(-0.05f) // Slightly slower but powerful
                        .weight(1.4f)
                        .knockback(1.0f)
                        .build(),
                new Color(64, 64, 64), MaterialType.METAL));
        
        // COPPER - Alternative mid-game option
        register(createMaterial("copper", "Copper",
                new MaterialStats.Builder()
                        .durability(180)
                        .attackDamage(3.5f)
                        .miningSpeed(5.0f)
                        .miningLevel(2)
                        .enchantability(12)
                        .attackSpeed(0.1f)
                        .weight(1.1f)
                        .build(),
                new Color(180, 120, 80), MaterialType.METAL));
        
        // EMERALD - Expensive but powerful
        register(createMaterial("emerald", "Emerald",
                new MaterialStats.Builder()
                        .durability(1200)
                        .attackDamage(5.5f)
                        .miningSpeed(7.0f)
                        .miningLevel(3)
                        .enchantability(18)
                        .attackSpeed(0.1f)
                        .weight(0.9f)
                        .build(),
                new Color(0, 255, 0), MaterialType.CRYSTAL));
        
        // OBSIDIAN - Heavy, durable, slow
        register(createMaterial("obsidian", "Obsidian",
                new MaterialStats.Builder()
                        .durability(3000)
                        .attackDamage(7.0f)
                        .miningSpeed(3.0f)
                        .miningLevel(3)
                        .enchantability(3)
                        .attackSpeed(-0.3f)  // Very slow
                        .weight(2.0f)        // Very heavy
                        .knockback(1.5f)
                        .build(),
                new Color(40, 0, 80), MaterialType.SPECIAL));
        
        // BONE - Unique lightweight option
        register(createMaterial("bone", "Bone",
                new MaterialStats.Builder()
                        .durability(150)
                        .attackDamage(3.0f)
                        .miningSpeed(4.0f)
                        .miningLevel(1)
                        .enchantability(17)
                        .attackSpeed(0.25f)  // Very fast
                        .weight(0.6f)        // Lightest material
                        .build(),
                new Color(220, 220, 190), MaterialType.SPECIAL));
        
        initialized = true;
        MoltenSmith.LOGGER.info("Registered {} materials", MATERIALS.size());
    }
    
    /**
     * Helper method to create a material with ResourceLocation
     */
    private static Material createMaterial(String path, String name, MaterialStats stats, Color color, MaterialType type) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MoltenSmith.MODID, path);
        return new Material(id, name, stats, color, type);
    }
    
    /**
     * Get the number of registered materials
     */
    public static int size() {
        return MATERIALS.size();
    }
    
    /**
     * Clear all materials (for testing)
     */
    public static void clear() {
        MATERIALS.clear();
        initialized = false;
    }
}
