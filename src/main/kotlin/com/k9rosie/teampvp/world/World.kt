package com.k9rosie.teampvp.world

import com.k9rosie.teampvp.team.Team
import org.bukkit.Location
import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.World as BukkitWorld

class World(val name: String, val bukkitWorld: BukkitWorld) : ConfigurationSerializable {
    companion object {
        val worlds = hashMapOf<String, World>()

        fun create(name: String, bukkitWorld: BukkitWorld): World {
            val world = World(name, bukkitWorld)
            worlds[name] = world
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

    private fun findType(regionType: Region.RegionType): List<Region> = regions.values.filter { it.regionType == regionType }

    override fun serialize(): MutableMap<String, Any> {
        return hashMapOf()
    }
}