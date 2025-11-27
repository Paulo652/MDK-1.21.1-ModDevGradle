package com.paulo.moltensmith.materials;

/**
 * Enum representing the type/category of a material
 */
public enum MaterialType {
    WOOD("wood"),
    STONE("stone"),
    METAL("metal"),
    CRYSTAL("crystal"),
    SPECIAL("special");
    
    private final String name;
    
    MaterialType(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isMetal() {
        return this == METAL;
    }
    
    public boolean isOrganic() {
        return this == WOOD;
    }
    
    public boolean isHardMaterial() {
        return this == CRYSTAL || this == STONE;
    }
}
