package com.k9rosie.teampvp

import org.bukkit.Bukkit
import org.bukkit.entity.Player as BukkitPlayer

class Player(
    val bukkitPlayer: BukkitPlayer
) {
    lateinit var state: PlayerState
    var team: Team = state.team

    companion object {
        val all = mutableMapOf<BukkitPlayer, Player>()

        fun fromUsername(username: String): Player = all[Bukkit.getPlayer(username)]
            ?: error(NLS.PLAYER_NOT_FOUND.parse(mapOf(":username" to username)))
    }
}