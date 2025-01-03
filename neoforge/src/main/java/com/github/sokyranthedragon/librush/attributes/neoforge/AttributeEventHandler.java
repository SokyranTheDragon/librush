package com.github.sokyranthedragon.librush.attributes.neoforge;

import com.github.sokyranthedragon.librush.LibrushMod;
import com.github.sokyranthedragon.librush.attributes.LibrushAttributes;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

@EventBusSubscriber(modid = LibrushMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class AttributeEventHandler
{
    @SubscribeEvent
    private static void onEntityAttributeModificationEvent(EntityAttributeModificationEvent event)
    {
        event.add(EntityType.PLAYER, LibrushAttributes.BRUSH_SWEEP_DURATION);
    }
}