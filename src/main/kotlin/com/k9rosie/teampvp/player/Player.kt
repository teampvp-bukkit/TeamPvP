package com.k9rosie.teampvp.player

import com.k9rosie.teampvp.events.PlayerJoin
import org.bukkit.Bukkit
import org.bukkit.entity.Player as BukkitPlayer

class Player(var bukkitPlayer: BukkitPlayer) {
    companion object {
        val players = mutableMapOf<BukkitPlayer, Player>()

        init {
            PlayerJoin on {
                val player = create(it.event.player)
            }
        }

        fun create(bukkitPlayer: BukkitPlayer): Player {
            val new = Player(bukkitPlayer)
            players[bukkitPlayer] = new
            return new
        }

        fun fromUsername(username: String): Player? = players[Bukkit.getPlayer(username)]
    }

    val flags = mutableMapOf<String, Any?>()
    //val dbModel = PlayerModel[bukkitPlayer.uniqueId]
    lateinit var state: PlayerState
}