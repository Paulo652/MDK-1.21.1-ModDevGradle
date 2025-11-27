package com.paulo.moltensmith.materials;

import net.minecraft.network.chat.Component;

/**
 * Represents a special trait/ability that a material can have
 * Examples: Fire Resistance (Netherite), High Enchantability (Gold), Self-Repair (Wood)
 */
public class MaterialTrait {
    private final String id;
    private final String name;
    private final String description;
    private final TraitType type;
    
    public MaterialTrait(String id, String name, String description, TraitType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Component getDisplayName() {
        return Component.translatable("trait.moltensmith." + id);
    }
    
    public String getDescription() {
        return description;
    }
    
    public Component getDescriptionComponent() {
        return Component.translatable("trait.moltensmith." + id + ".desc");
    }
    
    public TraitType getType() {
        return type;
    }
    
    /**
     * Types of traits
     */
    public enum TraitType {
        DEFENSIVE,    // Reduces damage taken, increases durability
        OFFENSIVE,    // Increases damage dealt
        UTILITY,      // Special abilities (silk touch, fortune-like effects)
        ENVIRONMENTAL,// Fire resistance, water breathing, etc.
        SPECIAL       // Unique effects
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MaterialTrait)) return false;
        MaterialTrait other = (MaterialTrait) obj;
        return id.equals(other.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
