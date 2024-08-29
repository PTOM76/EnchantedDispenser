package net.pitan76.enchanteddispenser.mixinimpl

import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPointer
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

object ProjectileDispenserBehaviorMixinImpl {
    @JvmStatic
    fun dispenseSilently(pointer: BlockPointer?, stack: ItemStack?, cir: CallbackInfoReturnable<ItemStack?>?) {
    }
}
