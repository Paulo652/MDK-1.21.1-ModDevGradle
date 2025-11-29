package com.paulo.moltensmith.items.parts;

import com.paulo.moltensmith.MoltenSmith;
import com.paulo.moltensmith.materials.Material;
import com.paulo.moltensmith.materials.MaterialRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

/**
 * Base class for all tool/weapon parts
 * Parts are created from materials via the smeltery and molds
 */
public class ToolPart extends Item {
    private final PartType partType;
    
    public ToolPart(PartType partType, Properties properties) {
        super(properties);
        this.partType = partType;
    }
    
    public PartType getPartType() {
        return partType;
    }
    
    /**
     * Get the material of this part from NBT
     */
    public static Material getMaterial(ItemStack stack) {
        if (stack.isEmpty() || !stack.has(net.minecraft.core.component.DataComponents.CUSTOM_DATA)) {
            return null;
        }
        
        var customData = stack.get(net.minecraft.core.component.DataComponents.CUSTOM_DATA);
        if (customData == null) {
            return null;
        }
        
        String materialId = customData.copyTag().getString("Material");
        if (materialId.isEmpty()) {
            return null;
        }
        
        return MaterialRegistry.get(ResourceLocation.parse(materialId)).orElse(null);
    }
    
    /**
     * Set the material of this part in NBT
     */
    public static void setMaterial(ItemStack stack, Material material) {
        var tag = new net.minecraft.nbt.CompoundTag();
        tag.putString("Material", material.getId().toString());
        stack.set(net.minecraft.core.component.DataComponents.CUSTOM_DATA, 
            net.minecraft.world.item.component.CustomData.of(tag));
    }
    
    /**
     * Create a part item with a specific material
     */
    public static ItemStack create(ToolPart part, Material material) {
        ItemStack stack = new ItemStack(part);
        setMaterial(stack, material);
        return stack;
    }
    
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        Material material = getMaterial(stack);
        
        if (material != null) {
            // Material name
            tooltip.add(Component.literal("Material: ")
                    .withStyle(ChatFormatting.GRAY)
                    .append(material.getDisplayName()
                            .copy().withStyle(ChatFormatting.YELLOW)));
            
            // Part type
            tooltip.add(Component.literal("Type: ")
                    .withStyle(ChatFormatting.GRAY)
                    .append(Component.literal(partType.getDisplayName())
                            .withStyle(ChatFormatting.AQUA)));
            
            // Material stats preview
            if (flag.hasShiftDown()) {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("Material Stats:")
                        .withStyle(ChatFormatting.GOLD));
                
                var stats = material.getStats();
                tooltip.add(Component.literal(" • Durability: " + stats.getDurability())
                        .withStyle(ChatFormatting.GREEN));
                tooltip.add(Component.literal(" • Attack Damage: " + stats.getAttackDamage())
                        .withStyle(ChatFormatting.RED));
                tooltip.add(Component.literal(" • Mining Speed: " + stats.getMiningSpeed())
                        .withStyle(ChatFormatting.BLUE));
            }
        } else {
            tooltip.add(Component.literal("Material: Unknown")
                    .withStyle(ChatFormatting.RED));
        }
        
        super.appendHoverText(stack, context, tooltip, flag);
    }
    
    @Override
    public Component getName(ItemStack stack) {
        Material material = getMaterial(stack);
        if (material != null) {
            return Component.literal(material.getDisplayName() + " " + partType.getDisplayName());
        }
        return super.getName(stack);
    }
}
