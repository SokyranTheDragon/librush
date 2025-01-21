package com.github.sokyranthedragon.librush.datagen.fabric;

import com.github.sokyranthedragon.librush.attributes.LibrushAttributes;
import com.github.sokyranthedragon.librush.config.LibrushConfigConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

class LibrushLanguageGenerator extends FabricLanguageProvider
{
    protected LibrushLanguageGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder)
    {
        translationBuilder.add(LibrushAttributes.BRUSH_SWEEP_DURATION, "Brush sweep duration");
        translationBuilder.add(LibrushAttributes.BRUSH_SWEEPS_TO_FINISH, "Brush sweeps to finish sweeping");

        addConfig(translationBuilder, LibrushConfigConstants.BASE_BRUSH_SWEEP_DURATION_KEY, "Base brush sweep duration", LibrushConfigConstants.BASE_BRUSH_SWEEP_DURATION_TOOLTIP);
        addConfig(translationBuilder, LibrushConfigConstants.BASE_BRUSH_SWEEPS_TO_FINISH_KEY, "Base sweeps to finish sweeping");
    }

    private void addConfig(@NotNull TranslationBuilder builder, @NotNull String key, @NotNull String value)
    {
        addConfig(builder, key, value, null);
    }

    private void addConfig(@NotNull TranslationBuilder builder, @NotNull String key, @NotNull String value, String tooltip)
    {
        builder.add(key, value);
        if (!StringUtil.isNullOrEmpty(tooltip))
            builder.add(key + ".tooltip", tooltip);
    }
}