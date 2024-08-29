package net.pitan76.enchanteddispenser.mixinimpl

import net.minecraft.block.BlockState
import net.minecraft.block.entity.DispenserBlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.pitan76.enchanteddispenser.mixin.DispenserBlockEntityMixin
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

object BlockMixinImpl {
    @JvmStatic
    fun onPlaced(world: World, pos: BlockPos, state: BlockState, placer: LivingEntity, stack: ItemStack, ci: CallbackInfo) {
        if (world.isClient) return
        if (stack.item != Items.DISPENSER) return

        // Enchantment
        val enchantmentComponent = EnchantmentHelper.getEnchantments(stack)
        if (enchantmentComponent.isEmpty) return

        val enchantmentEntries = enchantmentComponent.enchantmentEntries
        if (enchantmentEntries.isEmpty()) return

        val blockEntity = world.getBlockEntity(pos)
        if (blockEntity !is DispenserBlockEntity) return

        // cast
        //((DispenserBlockEntityMixin)blockEntity)
        val dispenserBlockEntityMixin = blockEntity as DispenserBlockEntityMixin

        for (enchantmentEntry in enchantmentEntries) {
            val enchantment = enchantmentEntry.key
            val level = enchantmentEntry.intValue
            dispenserBlockEntityMixin.`enchanteddispenser$enchantments`[enchantment] = level
        }
    }
}
