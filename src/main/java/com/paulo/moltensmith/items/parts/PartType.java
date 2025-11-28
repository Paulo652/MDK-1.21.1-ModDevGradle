package com.paulo.moltensmith.items.parts;

/**
 * Defines the different types of tool/weapon parts
 * Each type has specific roles in weapon assembly
 */
public enum PartType {
    // HEADS/BLADES - Primary damage and functionality
    KNIFE_BLADE("knife_blade", "Knife Blade", PartCategory.HEAD),
    SWORD_BLADE("sword_blade", "Sword Blade", PartCategory.HEAD),
    KATANA_BLADE("katana_blade", "Katana Blade", PartCategory.HEAD),
    SPEARHEAD("spearhead", "Spearhead", PartCategory.HEAD),
    AXE_HEAD("axe_head", "Axe Head", PartCategory.HEAD),
    PICKAXE_HEAD("pickaxe_head", "Pickaxe Head", PartCategory.HEAD),
    SHOVEL_HEAD("shovel_head", "Shovel Head", PartCategory.HEAD),
    
    // HANDLES - Affect attack speed, reach, and grip
    SHORT_HANDLE("short_handle", "Short Handle", PartCategory.HANDLE),    // One-handed weapons
    MEDIUM_HANDLE("medium_handle", "Medium Handle", PartCategory.HANDLE), // Versatile
    LONG_HANDLE("long_handle", "Long Handle", PartCategory.HANDLE),       // Two-handed weapons/tools
    
    // GUARDS - Protection and durability bonus
    SMALL_GUARD("small_guard", "Small Guard", PartCategory.GUARD),
    MEDIUM_GUARD("medium_guard", "Medium Guard", PartCategory.GUARD),
    LARGE_GUARD("large_guard", "Large Guard", PartCategory.GUARD),
    
    // BINDINGS - Connect parts, add durability
    BINDING("binding", "Binding", PartCategory.BINDING),
    
    // POMMELS - Balance and knockback
    POMMEL("pommel", "Pommel", PartCategory.POMMEL);
    
    private final String id;
    private final String displayName;
    private final PartCategory category;
    
    PartType(String id, String displayName, PartCategory category) {
        this.id = id;
        this.displayName = displayName;
        this.category = category;
    }
    
    public String getId() {
        return id;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public PartCategory getCategory() {
        return category;
    }
    
    /**
     * Categories of parts for organization
     */
    public enum PartCategory {
        HEAD,      // Primary damage source
        HANDLE,    // Grip and reach
        GUARD,     // Protection
        BINDING,   // Connector
        POMMEL     // Balance weight
    }
}
