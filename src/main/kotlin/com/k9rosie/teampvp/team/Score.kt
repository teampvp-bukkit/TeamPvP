package com.k9rosie.teampvp.team

import org.bukkit.scoreboard.Score as BukkitScore

class Score(val team: Team, var value: Int, val bukkitScore: BukkitScore) {
    init {
        bukkitScore.score = value
    }
}