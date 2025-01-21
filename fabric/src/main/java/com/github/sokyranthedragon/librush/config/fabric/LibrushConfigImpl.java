package com.github.sokyranthedragon.librush.config.fabric;

import net.minecraft.world.item.BrushItem;

public class LibrushConfigImpl
{
    public static int getDefaultBrushSweepDuration()
    {
        return BrushItem.ANIMATION_DURATION;
    }

    public static int getDefaultBrushSweepsToFinish()
    {
        return 10;
    }
}
