package net.pitan76.enchanteddispenser

import net.minecraft.util.Identifier
import net.pitan76.mcpitanlib.api.registry.CompatRegistry
import net.pitan76.mcpitanlib.api.util.IdentifierUtil
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object EnchantedDispenser {
    const val MOD_NAME: String = "Enchanted Dispenser"
    const val MOD_ID: String = "enchanteddispenser"

    private val LOGGER: Logger = LogManager.getLogger();

    val registry: CompatRegistry = CompatRegistry.create(MOD_ID)

    fun init() {
        log("Initialize")

        registry.allRegister()
    }

    @JvmStatic
    fun log(string: String) {
        LOGGER.log(Level.INFO, "[${MOD_NAME}] $string")
    }

    @JvmStatic
    fun id(id: String): Identifier {
        return IdentifierUtil.id(MOD_ID, id)
    }

}
