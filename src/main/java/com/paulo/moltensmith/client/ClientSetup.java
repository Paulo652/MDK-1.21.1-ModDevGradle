package com.paulo.moltensmith.client;

import com.paulo.moltensmith.blockentities.ModBlockEntities;
import com.paulo.moltensmith.client.renderer.EmberHearthBERRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import static com.paulo.moltensmith.MoltenSmith.MODID;

/**
 * Client-side event handlers for MoltenSmith
 */
@EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class ClientSetup {
    
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.EMBER_HEARTH.get(), 
                                         EmberHearthBERRenderer::new);
    }
}
