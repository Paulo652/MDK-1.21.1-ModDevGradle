package com.paulo.moltensmith.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.paulo.moltensmith.blockentities.EmberHearthBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

/**
 * Renders items on top of the Ember Hearth Bed with heat-based color tinting
 */
public class EmberHearthBERRenderer implements BlockEntityRenderer<EmberHearthBlockEntity> {
    private final ItemRenderer itemRenderer;
    
    public EmberHearthBERRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }
    
    @Override
    public void render(EmberHearthBlockEntity blockEntity, float partialTicks, PoseStack poseStack, 
                      MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        
        // Render up to 4 items in a 2x2 grid
        float[][] positions = {
            {0.35f, 0.65f}, // Slot 0: Left-Front
            {0.65f, 0.65f}, // Slot 1: Right-Front
            {0.35f, 0.35f}, // Slot 2: Left-Back
            {0.65f, 0.35f}  // Slot 3: Right-Back
        };
        
        for (int i = 0; i < 4; i++) {
            ItemStack stack = blockEntity.getItem(i);
            if (stack.isEmpty()) continue;
            
            int heatLevel = blockEntity.getHeatLevel(i);
            
            poseStack.pushPose();
            
            // Position item on top of block
            poseStack.translate(positions[i][0], 1.0625, positions[i][1]); // Slightly above block surface
            poseStack.scale(0.4f, 0.4f, 0.4f); // Scale down the item
            poseStack.mulPose(Axis.XP.rotationDegrees(90)); // Lay flat
            
            // Enhanced light level when hot
            int light = combinedLight;
            if (heatLevel > 50) {
                light = 0xF000F0; // Maximum brightness when very hot
            }
            
            // TODO: Implement color tinting for heated items
            // Calculate red tint based on heat (0-100 -> RGB)
            // int red = 255;
            // int green = Math.max(0, 255 - (int)(heatLevel * 2.55f));
            // int blue = Math.max(0, 255 - (int)(heatLevel * 2.55f));
            
            // Render the item with color tint
            itemRenderer.renderStatic(stack, ItemDisplayContext.GROUND, light, 
                                     OverlayTexture.NO_OVERLAY, poseStack, buffer, 
                                     blockEntity.getLevel(), 0);
            
            poseStack.popPose();
        }
    }
}
