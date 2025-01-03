package com.github.sokyranthedragon.librush.attributes.neoforge;

import com.github.sokyranthedragon.librush.LibrushMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LibrushAttributesImpl
{
    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, LibrushMod.MOD_ID);

    public static Holder<Attribute> register(String id, Attribute attribute)
    {
        return ATTRIBUTES.register(id, () -> attribute);
    }

    public static void init(IEventBus bus)
    {
        ATTRIBUTES.register(bus);
    }
}