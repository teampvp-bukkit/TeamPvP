package com.k9rosie.teampvp.game

import com.k9rosie.teampvp.Plugin
import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.team.Team
import org.bukkit.event.Listener

interface Gamemode {
    val name: String
    val timer: Int
    val rounds: Int
    val winningTeams: List<Team>
    val initialScores: Map<Team, Int>
    fun makeDeathTimer(player: Player? = null): GameTimer
}