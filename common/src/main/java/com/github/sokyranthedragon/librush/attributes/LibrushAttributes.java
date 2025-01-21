package com.github.sokyranthedragon.librush.attributes;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public final class LibrushAttributes
{
    private LibrushAttributes()
    {
        // Prevent instantiation
    }

    // /give @s brush[attribute_modifiers=[{type:"librush:brush_sweep_duration", amount:1.0, operation:"add_value", id:"example:custom_damage", slot:"hand"}]]
    public static final Holder<Attribute> BRUSH_SWEEP_DURATION = register("brush_sweep_duration",
        new RangedAttribute("attribute.name.librush.brush_sweep_duration", 0, -1024, 1024)
            .setSentiment(Attribute.Sentiment.NEGATIVE)
            .setSyncable(true));

    public static final Holder<Attribute> BRUSH_SWEEPS_TO_FINISH = register("brush_sweeps_to_finish",
        new RangedAttribute("attribute.name.librush.brush_sweeps_to_finish", 0, -1024, 1024)
            .setSentiment(Attribute.Sentiment.NEGATIVE)
            .setSyncable(true));

    @ExpectPlatform
    private static Holder<Attribute> register(String id, Attribute attribute)
    {
        throw new AssertionError("This method should have been replaced by Architectury.");
    }

    public static void init()
    {
        // Need to access this class to ensure the static final fields are initialized.
    }
}