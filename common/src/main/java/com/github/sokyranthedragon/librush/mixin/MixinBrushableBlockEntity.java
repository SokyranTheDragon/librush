package com.github.sokyranthedragon.librush.mixin;

import com.github.sokyranthedragon.librush.attributes.LibrushAttributes;
import com.github.sokyranthedragon.librush.config.LibrushConfig;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(BrushableBlockEntity.class)
public abstract class MixinBrushableBlockEntity
{
    @ModifyConstant(method = "brush", constant = @Constant(longValue = 10L))
    private long modifyBrushCooldown(long value, @Local(argsOnly = true) Player player)
    {
        AttributeInstance attribute = player.getAttribute(LibrushAttributes.BRUSH_SWEEP_DURATION);
        if (attribute == null)
            return value;

        // The game prevents the brushable block from being updated more often than
        // once every 10 ticks. As we're lowering the frequency of updates in BrushItem,
        // we also need to lower the tick cooldown in the entity as well.
        return Math.max((long)(LibrushConfig.getDefaultBrushSweepDuration() + attribute.getValue()), 1L);
    }

    @ModifyConstant(method = "brush", constant = @Constant(longValue = 40L))
    private long modifyBrushResetsAtTick(long value, @Local(argsOnly = true) Player player)
    {
        AttributeInstance attribute = player.getAttribute(LibrushAttributes.BRUSH_SWEEP_DURATION);
        if (attribute == null)
            return value;

        // The brushable block resets its state 40 ticks after being brushed for the last time.
        // In cases where we increase the brush is very slow we need to ensure the cooldown is
        // appropriately long as well. Set the cooldown to brush time + 30, which will result in
        // 40 ticks with vanilla brushing duration.
        return Math.max((long)(LibrushConfig.getDefaultBrushSweepDuration() + 30 + attribute.getValue()), 30L);
    }
}
