package com.github.sokyranthedragon.librush.datagen.fabric;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class LibrushDatagen implements DataGeneratorEntrypoint
{
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator)
    {
        var pack = generator.createPack();

        pack.addProvider(LibrushLanguageGenerator::new);
    }
}