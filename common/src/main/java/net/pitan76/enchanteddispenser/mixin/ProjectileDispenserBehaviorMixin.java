package net.pitan76.enchanteddispenser.mixin;

import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.pitan76.enchanteddispenser.mixinimpl.ProjectileDispenserBehaviorMixinImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ProjectileDispenserBehavior.class)
public class ProjectileDispenserBehaviorMixin {
    @Inject(method = "dispenseSilently", at = @At("TAIL"))
    private void enchanteddispenser$dispenseSilently(BlockPointer pointer, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        ProjectileDispenserBehaviorMixinImpl.dispenseSilently(pointer, stack, cir);
    }
}
