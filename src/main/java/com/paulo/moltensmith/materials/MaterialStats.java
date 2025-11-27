package com.paulo.moltensmith.materials;

/**
 * Holds all the statistical properties of a material
 */
public class MaterialStats {
    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantability;
    private final float attackSpeed; // Modifier to weapon attack speed
    private final float knockback;   // Knockback resistance/power
    private final float weight;      // Affects handling and speed
    
    private MaterialStats(Builder builder) {
        this.durability = builder.durability;
        this.miningSpeed = builder.miningSpeed;
        this.attackDamage = builder.attackDamage;
        this.miningLevel = builder.miningLevel;
        this.enchantability = builder.enchantability;
        this.attackSpeed = builder.attackSpeed;
        this.knockback = builder.knockback;
        this.weight = builder.weight;
    }
    
    // Getters
    public int getDurability() { return durability; }
    public float getMiningSpeed() { return miningSpeed; }
    public float getAttackDamage() { return attackDamage; }
    public int getMiningLevel() { return miningLevel; }
    public int getEnchantability() { return enchantability; }
    public float getAttackSpeed() { return attackSpeed; }
    public float getKnockback() { return knockback; }
    public float getWeight() { return weight; }
    
    /**
     * Builder pattern for creating MaterialStats
     */
    public static class Builder {
        private int durability = 100;
        private float miningSpeed = 1.0f;
        private float attackDamage = 1.0f;
        private int miningLevel = 0;
        private int enchantability = 1;
        private float attackSpeed = 0.0f;
        private float knockback = 0.0f;
        private float weight = 1.0f;
        
        public Builder durability(int durability) {
            this.durability = durability;
            return this;
        }
        
        public Builder miningSpeed(float miningSpeed) {
            this.miningSpeed = miningSpeed;
            return this;
        }
        
        public Builder attackDamage(float attackDamage) {
            this.attackDamage = attackDamage;
            return this;
        }
        
        public Builder miningLevel(int miningLevel) {
            this.miningLevel = miningLevel;
            return this;
        }
        
        public Builder enchantability(int enchantability) {
            this.enchantability = enchantability;
            return this;
        }
        
        public Builder attackSpeed(float attackSpeed) {
            this.attackSpeed = attackSpeed;
            return this;
        }
        
        public Builder knockback(float knockback) {
            this.knockback = knockback;
            return this;
        }
        
        public Builder weight(float weight) {
            this.weight = weight;
            return this;
        }
        
        public MaterialStats build() {
            return new MaterialStats(this);
        }
    }
    
    @Override
    public String toString() {
        return String.format("MaterialStats[dur=%d, dmg=%.1f, spd=%.1f, lvl=%d, ench=%d]",
                durability, attackDamage, miningSpeed, miningLevel, enchantability);
    }
}
