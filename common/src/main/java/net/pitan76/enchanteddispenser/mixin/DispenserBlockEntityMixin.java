package net.pitan76.enchanteddispenser.mixin;

import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.pitan76.enchanteddispenser.mixinimpl.DispenserBlockEntityMixinImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DispenserBlockEntity.class)
public class DispenserBlockEntityMixin {
    @Inject(method = "writeNbt", at = @At("TAIL"))
    private void enchanteddispenser$writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup, CallbackInfo ci) {
        DispenserBlockEntityMixinImpl.writeNbt(nbt, registryLookup, ci);
    }

    @Inject(method = "readNbt", at = @At("TAIL"))
    private void enchanteddispenser$readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup, CallbackInfo ci) {
        DispenserBlockEntityMixinImpl.readNBt(nbt, registryLookup, ci);
    }
}
