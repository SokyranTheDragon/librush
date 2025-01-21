package com.github.sokyranthedragon.librush.mixin;

import com.github.sokyranthedragon.librush.attributes.AttributeUtils;
import com.github.sokyranthedragon.librush.attributes.LibrushAttributes;
import com.github.sokyranthedragon.librush.config.LibrushConfig;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrushItem.class)
public abstract class MixinBrushItem
{
    @ModifyConstant(method = "onUseTick", constant = @Constant(intValue = BrushItem.ANIMATION_DURATION))
    private int replaceUseDuration(int value, @Local(argsOnly = true) LivingEntity livingEntity)
    {
        // Change the use duration based on the current brush's use duration.
        // getCurrentBrushUseTime() should always return 1 or more, using lower values would cause bugs.
        return Math.max((int)(LibrushConfig.getDefaultBrushSweepDuration() + AttributeUtils.getValueOrDefault(livingEntity, LibrushAttributes.BRUSH_SWEEP_DURATION)), 1);
    }

    @ModifyConstant(method = "onUseTick", constant = @Constant(intValue = 5))
    private int replaceTargetDuration(int value, @Local(argsOnly = true) LivingEntity livingEntity)
    {
        // The original code is (i % 10 == 5), so we need to drop
        // both 10 and 5 or else brushing won't be possible.
        // getCurrentBrushUseTime() should always return 1 or more, which after
        // halving will be 0 or more (but always lower than the brushing duration).
        // Values smaller than 0 or equal to/bigger than the brushing duration will cause bugs.
        return Math.max((int)(LibrushConfig.getDefaultBrushSweepDuration() + AttributeUtils.getValueOrDefault(livingEntity, LibrushAttributes.BRUSH_SWEEP_DURATION)), 1) / 2;
    }

    @Inject(method = "getUseDuration", at = @At("HEAD"), cancellable = true)
    private void replaceUseDuration(ItemStack itemStack, LivingEntity livingEntity, CallbackInfoReturnable<Integer> cir)
    {
        // Return the duration of a single sweeping operation, multiplied by 10.
        // This is done to ensure that brushes whose use single sweep duration
        // was increased higher than the default value of 10 will still be able
        // to finish their sweeping.
        cir.setReturnValue(Math.max((int)(LibrushConfig.getDefaultBrushSweepDuration() + AttributeUtils.getValueOrDefault(livingEntity, LibrushAttributes.BRUSH_SWEEP_DURATION)) * 20, 20));
    }
}