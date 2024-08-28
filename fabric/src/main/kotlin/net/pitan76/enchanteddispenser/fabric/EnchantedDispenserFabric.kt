package net.pitan76.enchanteddispenser.fabric

import net.fabricmc.api.ModInitializer
import net.pitan76.enchanteddispenser.EnchantedDispenser

class EnchantedDispenserFabric : ModInitializer {
    override fun onInitialize() {
        EnchantedDispenser.init()
    }
}
