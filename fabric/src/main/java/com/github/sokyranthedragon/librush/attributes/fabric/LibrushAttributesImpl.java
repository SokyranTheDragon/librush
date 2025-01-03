package com.github.sokyranthedragon.librush.attributes.fabric;

import com.github.sokyranthedragon.librush.LibrushMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class LibrushAttributesImpl
{
    public static Holder<Attribute> register(String id, Attribute attribute)
    {
        return Registry.registerForHolder(
                BuiltInRegistries.ATTRIBUTE,
                ResourceLocation.fromNamespaceAndPath(LibrushMod.MOD_ID, id),
                attribute);
    }
}