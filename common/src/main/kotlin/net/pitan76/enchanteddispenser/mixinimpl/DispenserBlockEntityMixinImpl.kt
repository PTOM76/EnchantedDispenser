package net.pitan76.enchanteddispenser.mixinimpl

import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.RegistryWrapper
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

object DispenserBlockEntityMixinImpl {
    @JvmStatic
    fun writeNbt(nbt: NbtCompound?, registryLookup: RegistryWrapper.WrapperLookup?, ci: CallbackInfo?) {

    }

    @JvmStatic
    fun readNBt(nbt: NbtCompound?, registryLookup: RegistryWrapper.WrapperLookup?, ci: CallbackInfo?) {

    }
}
