package com.github.sokyranthedragon.librush.config.neoforge;

public class LibrushConfigImpl
{
    public static int getDefaultBrushSweepDuration()
    {
        return LibrushServerConfig.CONFIG.baseBrushSpeed.get();
    }
}
