package com.k9rosie.teampvp.gamemode

import com.k9rosie.teampvp.Plugin
import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.team.Team
import org.bukkit.event.Listener

interface Gamemode {
    val name: String

    fun winningTeams(): List<Team>
    fun deathTimer(player: Player)
    fun setup()
}