package com.k9rosie.teampvp.game

import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.team.Team
import com.k9rosie.teampvp.util.RepeatingTask

object DefaultGamemode : Gamemode {
    override val name: String
        get() = "none"

    override val initialTime: Long
        get() = 60*20 // 1 minute

    override val rounds: Int
        get() = 1

    override fun determineInitialScores(): Map<Team, Int> {
        val map = mutableMapOf<Team, Int>()

        Game.current.teamStates.entries.forEach {
            map[it.key] = 10
        }

        return map
    }

    override fun determineWinners(): Set<Team> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun makeDeathTimer(player: Player?): RepeatingTask {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}