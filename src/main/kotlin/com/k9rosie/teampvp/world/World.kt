package com.k9rosie.teampvp.world

import com.k9rosie.teampvp.Plugin
import com.k9rosie.teampvp.config.CoreCfg
import com.k9rosie.teampvp.config.WorldCfg
import com.k9rosie.teampvp.game.DefaultGamemode
import com.k9rosie.teampvp.game.Gamemode
import com.k9rosie.teampvp.team.Team
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.World as BukkitWorld

class World(
    val name: String,
    val bukkitWorld: BukkitWorld
) : ConfigurationSerializable {
    companion object {
        val all = hashMapOf<String, World>()
        val lobbyWorld = World(
            "lobby",
            Bukkit.getWorld(
                CoreCfg.worldSettings.getString("lobby")
                    ?: error("Lobby world isn't defined in core.yml."))
                ?: error("Lobby world hasn't been initialized by the server.")
        )

        init {
            CoreCfg.worldSettings.getStringList("enabled")?.forEach {
                val world = WorldCfg.worlds.getConfigurationSection(it)
                    ?: error("No world named $it defined in worlds.yml")
                val name = world.getString("name")
                    ?: error("This world does not have a name!")
                val bukkitWorld = Bukkit.getWorld(it)
                    ?: error("Bukkit does not know of a world named $it")
                val gamemode = Plugin.gamemodes[world.getString("gamemode")
                    ?: error("no gamemode defined in worlds.yml")]
                    val enabledTeams: List<Team> = world.getStringList("enabled_teams").map { t -> Team.all[t]
                        ?: error("team defined in $name in worlds.yml doesn't exist. Are you sure it's defined in " +
                                "teams.yml?")
                }

                create(name, bukkitWorld)
            }
        }

        fun create(name: String, bukkitWorld: BukkitWorld): World {
            val world = World(name, bukkitWorld)
            all[name] = world
            return world
        }
    }

    val spawns = hashMapOf<Team, Location>()
    val regions = hashMapOf<String, Region>()

    val battlefields: List<Region> = findType(Region.RegionType.BATTLEFIELD)
    val intermissionGates: List<Region> = findType(Region.RegionType.INTERMISSION_GATE)
    val deathRegions: List<Region> = findType(Region.RegionType.DEATH)
    val objectives: List<Region> = findType(Region.RegionType.OBJECTIVE)
    val baseRegions: List<Region> = findType(Region.RegionType.BASE)

    private fun findType(regionType: Region.RegionType): List<Region> = regions.values.filter {
        it.regionType == regionType
    }

    override fun serialize(): MutableMap<String, Any> {
        return hashMapOf()
    }

    fun reloadBattlefields() {
        battlefields
    }
}