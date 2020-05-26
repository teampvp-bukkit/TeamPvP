package com.k9rosie.teampvp.config

object TeamConfig : Config("teams.yml") {
    var teamSettings: Set<TeamSettings>

    init {
        teamSettings = yamlConfig.getMapList("teams").fold(mutableSetOf()) { map, element ->
            map.add(
                TeamSettings(
                    element["name"] as String,
                    element["color"] as String,
                    element["can_be_damaged"] as Boolean,
                    element["can_attack"] as Boolean,
                    element["friendly_fire"] as Boolean
                )
            )
            map
        }
    }

    class TeamSettings(
        val name: String,
        val color: String,
        val canBeDamaged: Boolean,
        val canAttack: Boolean,
        val friendlyFire: Boolean
    )
}