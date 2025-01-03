package com.github.sokyranthedragon.librush.mixin.fabric;

import com.github.sokyranthedragon.librush.attributes.LibrushAttributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class MixinPlayer
{
    @Inject(method = "createAttributes", at = @At("RETURN"))
    private static void injectBrushAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir)
    {
        cir.getReturnValue().add(LibrushAttributes.BRUSH_SWEEP_DURATION);
    }
}