package com.k9rosie.teampvp.team

import com.k9rosie.teampvp.player.Player
import org.bukkit.scoreboard.Team as BukkitTeam

class TeamState(val team: Team, val scoreboardTeam: BukkitTeam) {
    val players = hashSetOf<Player>()
}