package net.pitan76.enchanteddispenser.mixinimpl

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.registry.entry.RegistryEntryList
import net.minecraft.registry.tag.EnchantmentTags
import net.minecraft.util.math.random.Random
import net.pitan76.mcpitanlib.api.util.BlockUtil
import net.pitan76.mcpitanlib.api.util.MathUtil
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

object DispenserBlockEntityMixinImpl {

    val random: Random = MathUtil.createRandom()

    @JvmStatic
    fun writeNbt(nbt: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup, ci: CallbackInfo, enchantments: Map<RegistryEntry<Enchantment>, Int>) {
        val enchantmentNbt = NbtCompound()
        for (enchantmentEntry in enchantments) {
            val enchantment = enchantmentEntry.key
            enchantmentNbt.putInt(RegistryKey., enchantmentEntry.value)
            Registries.ENCHANTMENT_PROVIDER_TYPE.get(enchantment.key)
        }

        nbt.put("Enchantments", enchantmentNbt)
    }

    @JvmStatic
    fun readNBt(nbt: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup, ci: CallbackInfo, enchantments: Map<RegistryEntry<Enchantment>, Int>) {
        val enchantmentNbt = nbt.getCompound("Enchantments")
        for (key in enchantmentNbt.keys) {
            val optional = registryLookup.getOptionalWrapper(RegistryKeys.ENCHANTMENT)
            if (optional.isEmpty) continue

            val optional2 = optional.get().getOptional(EnchantmentTags.IN_ENCHANTING_TABLE)
            if (optional2.isEmpty) continue

            val enchantment = optional2.get().get(key)


            val level = enchantmentNbt.getInt(key)

            enchantments.plus(null to level)
        }
    }
}
