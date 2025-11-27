package com.paulo.moltensmith.materials;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class representing a material that can be used to craft modular weapons.
 * Each material has unique properties that affect weapon statistics.
 */
public class Material {
    private final ResourceLocation id;
    private final String name;
    private final MaterialStats stats;
    private final Color color;
    private final Map<String, MaterialTrait> traits;
    private final MaterialType type;
    
    public Material(ResourceLocation id, String name, MaterialStats stats, Color color, MaterialType type) {
        this.id = id;
        this.name = name;
        this.stats = stats;
        this.color = color;
        this.type = type;
        this.traits = new HashMap<>();
    }
    
    public ResourceLocation getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Component getDisplayName() {
        return Component.translatable("material.moltensmith." + id.getPath());
    }
    
    public MaterialStats getStats() {
        return stats;
    }
    
    public Color getColor() {
        return color;
    }
    
    public MaterialType getType() {
        return type;
    }
    
    public Map<String, MaterialTrait> getTraits() {
        return traits;
    }
    
    public void addTrait(MaterialTrait trait) {
        traits.put(trait.getId(), trait);
    }
    
    public boolean hasTrait(String traitId) {
        return traits.containsKey(traitId);
    }
    
    /**
     * Get the tier level for this material (0 = wood/gold, 1 = stone, 2 = iron, 3 = diamond, 4 = netherite)
     */
    public int getTierLevel() {
        return stats.getMiningLevel();
    }
    
    /**
     * Check if this material can be melted in the smeltery
     */
    public boolean isMeltable() {
        return type == MaterialType.METAL || type == MaterialType.CRYSTAL;
    }
    
    /**
     * Get the melting temperature in degrees (affects fuel consumption)
     */
    public int getMeltingTemperature() {
        return switch (type) {
            case WOOD -> 200;
            case STONE -> 800;
            case METAL -> 1200;
            case CRYSTAL -> 1500;
            case SPECIAL -> 1000;
        };
    }
    
    /**
     * Get the amount of molten material produced per ingot (in millibuckets)
     */
    public int getFluidPerIngot() {
        return 144; // Standard ingot = 144mb (one ingot = one ninth of a bucket)
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Material)) return false;
        Material other = (Material) obj;
        return id.equals(other.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    @Override
    public String toString() {
        return "Material{" + id + ", " + name + "}";
    }
}
