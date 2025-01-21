package com.github.sokyranthedragon.librush.attributes;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class AttributeUtils
{
    public static double getValueOrDefault(LivingEntity entity, Holder<Attribute> attribute)
    {
        var instance = entity.getAttribute(attribute);
        if (instance == null)
            return attribute.value().getDefaultValue();
        return instance.getValue();
    }

    private AttributeUtils()
    {
        // Prevent instantiation
    }
}