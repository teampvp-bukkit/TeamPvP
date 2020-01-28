package com.k9rosie.teampvp.game

import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.team.Team
import com.k9rosie.teampvp.util.RepeatingTask

interface Gamemode {
    val name: String
    val initialTime: Long
    val rounds: Int
    fun determineInitialScores(): Map<Team, Int>
    fun determineWinners(): Set<Team>
    fun makeDeathTimer(player: Player? = null): RepeatingTask
}