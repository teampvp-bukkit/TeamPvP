package com.k9rosie.teampvp

import com.k9rosie.teampvp.config.CoreConfig
import com.k9rosie.teampvp.config.WorldConfig
import org.bukkit.Bukkit
import org.bukkit.World as BukkitWorld

class World(
    val name: String,
    val bukkitWorld: BukkitWorld
) {
    companion object {
        val all = mutableMapOf<String, World>()
        val lobbyWorld = World(
            "Lobby",
            Bukkit.getWorld(CoreConfig.world.lobby)
                ?: error(NLS.WORLD_NONEXISTENT.parse(mapOf(":world" to CoreConfig.world.lobby)))
        )

        init {
            for (setting in WorldConfig.worldSettings) {
                create(
                    setting.name,
                    Bukkit.getWorld(setting.bukkitWorld)
                        ?: error(NLS.WORLD_NONEXISTENT.parse(mapOf(":world" to setting.bukkitWorld)))
                )
            }
        }

        fun create(
            name: String,
            bukkitWorld: BukkitWorld
        ): World {
            val new = World(name, bukkitWorld)
            all[name] = new
            return new
        }
    }
}