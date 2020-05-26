package com.k9rosie.teampvp

import com.k9rosie.teampvp.config.CoreConfig
import com.k9rosie.teampvp.config.TeamConfig
import org.bukkit.ChatColor

class Team(
    val name: String,
    val color: ChatColor,
    val canAttack: Boolean,
    val canBeDamaged: Boolean,
    val friendlyFire: Boolean
) {
    companion object {
        val all = mutableMapOf<String, Team>()
        val defaultTeam = Team(
            CoreConfig.game.defaultTeamName,
            ChatColor.valueOf(CoreConfig.game.defaultTeamColor.toUpperCase()),
            CoreConfig.game.defaultTeamCanAttack,
            CoreConfig.game.defaultTeamCanBeDamaged,
            CoreConfig.game.defaultTeamFriendlyFire
        )

        init {
            for (setting in TeamConfig.teamSettings) {
                create(
                    setting.name,
                    ChatColor.valueOf(setting.color.toUpperCase()),
                    setting.canAttack,
                    setting.canBeDamaged,
                    setting.friendlyFire
                )
            }
        }

        fun create(
            name: String,
            color: ChatColor,
            canAttack: Boolean,
            canBeDamaged: Boolean,
            friendlyFire: Boolean
        ): Team {
            val new = Team(name, color, canAttack, canBeDamaged, friendlyFire)
            all[name] = new
            return new
        }
    }


}