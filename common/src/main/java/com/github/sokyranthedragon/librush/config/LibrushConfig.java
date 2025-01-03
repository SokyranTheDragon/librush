package com.github.sokyranthedragon.librush.config;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class LibrushConfig
{
    @ExpectPlatform
    public static int getDefaultBrushSweepDuration()
    {
        throw new AssertionError("This method should have been replaced by Architectury.");
    }
}
