package com.github.sokyranthedragon.librush;

import com.github.sokyranthedragon.librush.attributes.LibrushAttributes;
import net.minecraft.resources.ResourceLocation;

public final class LibrushMod
{
    public static final String MOD_ID = "librush";

    public static void init()
    {
        // Nothing for now
        LibrushAttributes.init();
    }

    public static ResourceLocation resourceLocation(String id)
    {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
}