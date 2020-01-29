package com.k9rosie.teampvp.game

import com.k9rosie.teampvp.team.Score
import com.k9rosie.teampvp.team.Team
import org.bukkit.Bukkit
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.Scoreboard as BukkitScoreboard
import org.bukkit.scoreboard.Team as BukkitTeam

class Scoreboard(displayName: String = "") {
    val bukkitScoreboard: BukkitScoreboard = Bukkit.getScoreboardManager()?.newScoreboard
        ?: error("failed creating scoreboard")
    val sidebar: Objective = bukkitScoreboard.registerNewObjective("sidebar", "dummy", displayName)
    val healthNameplates: Objective = bukkitScoreboard.registerNewObjective(
        "showhealth",
        "health",
        "/ 20"
    )
    var displayName: String = displayName
        set(value) {
            field = value
            sidebar.displayName = value
        }

    init {
        sidebar.displaySlot = DisplaySlot.SIDEBAR

        Game.current.teams.keys.forEach {
            it.state?.score = Score(
                it,
                Game.current.gamemode.determineInitialScores()[it]
                    ?: error("gamemode doesn't have an initial score for this team!"),
                sidebar.getScore(it.color.toString() + it.name
                )
            )
        }

        healthNameplates.displaySlot = DisplaySlot.BELOW_NAME

        Bukkit.getOnlinePlayers().forEach {
            it.scoreboard = bukkitScoreboard
        }
    }

    fun register(team: Team): BukkitTeam {
        val bukkitTeam: BukkitTeam = bukkitScoreboard.registerNewTeam(team.color.toString() + team.name)
        bukkitTeam.prefix = team.color.toString()
        bukkitTeam.displayName = team.color.toString() + team.name
        bukkitTeam.setAllowFriendlyFire(team.friendlyFire)
        bukkitTeam.setCanSeeFriendlyInvisibles(false)
        return bukkitTeam
    }
}