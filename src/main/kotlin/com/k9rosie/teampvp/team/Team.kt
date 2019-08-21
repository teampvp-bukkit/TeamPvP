package com.k9rosie.teampvp.team

import org.bukkit.ChatColor

class Team(
    val name: String,
    val color: ChatColor,
    val canAttack: Boolean,
    val canBeHurt: Boolean,
    val friendlyFire: Boolean
) {
    companion object {
        val teams = hashMapOf<String, Team>()
        // the default team is the team players are assigned to before they join the game
        // this team does not have a team state
        var defaultTeam = create()

        fun create(
            name: String = "default",
            color: ChatColor = ChatColor.GRAY,
            canAttack: Boolean = false,
            canBeHurt: Boolean = false,
            friendlyFire: Boolean = false
        ): Team {
            val new = Team(name, color, canAttack, canBeHurt, friendlyFire)
            teams[name] = new
            return new
        }
    }

    var teamState: TeamState? = null
}