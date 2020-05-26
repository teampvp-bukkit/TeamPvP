package com.k9rosie.teampvp.config

object WorldConfig : Config("worlds.yml") {
    var worldSettings: Set<WorldSettings>

    init {
        worldSettings = yamlConfig.getMapList("worlds").fold(mutableSetOf()) { map, element ->
            val enabledTeams = element["enabled_teams"]
            if (enabledTeams is List<*>) {
                map.add(
                    WorldSettings(
                        element["bukkit_world"] as String,
                        element["name"] as String,
                        element["gamemode"] as String,
                        enabledTeams.filterIsInstance<String>()
                    )
                )
            }
            map
        }
    }

    class WorldSettings(
        val bukkitWorld: String,
        val name: String,
        val gamemode: String,
        val enabledTeams: List<String>
    )
}