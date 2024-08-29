package net.pitan76.enchanteddispenser.mixin;

import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.pitan76.enchanteddispenser.mixinimpl.DispenserBlockEntityMixinImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(DispenserBlockEntity.class)
public class DispenserBlockEntityMixin {

    @Unique
    public Map<RegistryEntry<Enchantment>, Integer> enchanteddispenser$enchantments = new HashMap<>();

    @Inject(method = "writeNbt", at = @At("TAIL"))
    private void enchanteddispenser$writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup, CallbackInfo ci) {
        DispenserBlockEntityMixinImpl.writeNbt(nbt, registryLookup, ci, enchanteddispenser$enchantments);
    }

    @Inject(method = "readNbt", at = @At("TAIL"))
    private void enchanteddispenser$readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup, CallbackInfo ci) {
        DispenserBlockEntityMixinImpl.readNBt(nbt, registryLookup, ci, enchanteddispenser$enchantments);
    }
}
