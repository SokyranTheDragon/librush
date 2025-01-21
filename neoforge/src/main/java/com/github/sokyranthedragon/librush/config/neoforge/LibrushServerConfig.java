package com.github.sokyranthedragon.librush.config.neoforge;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.UnmodifiableCommentedConfig;
import com.github.sokyranthedragon.librush.config.LibrushConfigConstants;
import net.minecraft.world.item.BrushItem;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.jetbrains.annotations.Nullable;

public class LibrushServerConfig implements IConfigSpec
{
    public static final LibrushServerConfig CONFIG;
    public static final ModConfigSpec CONFIG_SPEC;

    public final ModConfigSpec.ConfigValue<Integer> baseBrushSpeed;
    public final ModConfigSpec.ConfigValue<Integer> baseBrushSweepsToFinish;

    private LibrushServerConfig(ModConfigSpec.Builder builder)
    {
        baseBrushSpeed = builder
            .translation(LibrushConfigConstants.BASE_BRUSH_SWEEP_DURATION_KEY)
            .comment(LibrushConfigConstants.BASE_BRUSH_SWEEP_DURATION_TOOLTIP, "The default (vanilla) duration is 10 ticks.")
            .defineInRange(LibrushConfigConstants.BASE_BRUSH_SWEEP_DURATION_ID, () -> BrushItem.ANIMATION_DURATION, 1, 1000);

        baseBrushSweepsToFinish = builder
            .translation(LibrushConfigConstants.BASE_BRUSH_SWEEPS_TO_FINISH_KEY)
            .defineInRange(LibrushConfigConstants.BASE_BRUSH_SWEEPS_TO_FINISH_ID, 10, 1, 1000);
    }

    static
    {
        var pair = new ModConfigSpec.Builder().configure(LibrushServerConfig::new);

        CONFIG = pair.getLeft();
        CONFIG_SPEC = pair.getRight();
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public void validateSpec(ModConfig config)
    {
    }

    @Override
    public boolean isCorrect(UnmodifiableCommentedConfig config)
    {
        return false;
    }

    @Override
    public void correct(CommentedConfig config)
    {
    }

    @Override
    public void acceptConfig(@Nullable ILoadedConfig config)
    {
    }
}
