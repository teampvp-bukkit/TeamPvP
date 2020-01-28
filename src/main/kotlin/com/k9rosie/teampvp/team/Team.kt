package com.k9rosie.teampvp.team

import com.k9rosie.teampvp.config.TeamCfg
import org.bukkit.ChatColor

class Team(
    val name: String,
    val color: ChatColor,
    val canAttack: Boolean,
    val canBeHurt: Boolean,
    val friendlyFire: Boolean
) {
    companion object {
        val all = hashMapOf<String, Team>()

        init {
            TeamCfg.teams.forEach {
                create(
                    it["name"] as String,
                    ChatColor.valueOf(it["color"] as String),
                    it["can_be_damaged"] as Boolean,
                    it["can_attack"] as Boolean,
                    it["friendly_fire"] as Boolean
                )
            }
        }

        // the default team is the team players are assigned to before they join the game
        // this team does not have a team state!
        var defaultTeam = create()

        fun create(
            name: String = "default",
            color: ChatColor = ChatColor.GRAY,
            canAttack: Boolean = false,
            canBeHurt: Boolean = false,
            friendlyFire: Boolean = false
        ): Team {
            val new = Team(name, color, canAttack, canBeHurt, friendlyFire)
            all[name] = new
            return new
        }
    }

    // team states do not get initialized and assigned until the team is actually a member of the game
    var state: TeamState? = null
}