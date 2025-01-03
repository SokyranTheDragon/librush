package com.github.sokyranthedragon.librush.neoforge;

import com.github.sokyranthedragon.librush.LibrushMod;
import com.github.sokyranthedragon.librush.attributes.neoforge.LibrushAttributesImpl;
import com.github.sokyranthedragon.librush.config.neoforge.LibrushServerConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(LibrushMod.MOD_ID)
public final class LibrushModNeoForge
{
    public LibrushModNeoForge(IEventBus bus, ModContainer container, Dist dist)
    {
        // Init registers
        LibrushAttributesImpl.init(bus);

        // Init config
        container.registerConfig(ModConfig.Type.SERVER, LibrushServerConfig.CONFIG_SPEC);
        if (dist.isClient())
            container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        // Run our common setup.
        LibrushMod.init();
    }
}