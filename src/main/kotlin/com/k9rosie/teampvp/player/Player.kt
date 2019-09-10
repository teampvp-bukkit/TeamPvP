package com.k9rosie.teampvp.player

import com.k9rosie.teampvp.db.models.PlayerModel
import org.bukkit.Bukkit
import org.bukkit.entity.Player as BukkitPlayer

class Player(var bukkitPlayer: BukkitPlayer) {
    companion object {
        val all = mutableMapOf<BukkitPlayer, Player>()

        fun create(bukkitPlayer: BukkitPlayer): Player {
            val new = Player(bukkitPlayer)
            all[bukkitPlayer] = new
            return new
        }

        fun fromUsername(username: String): Player = all[Bukkit.getPlayer(username)] ?: error("Player $username doesn't exist")
    }

    val flags = mutableMapOf<String, Any?>()
    val dbModel = PlayerModel[bukkitPlayer.uniqueId]
    lateinit var state: PlayerState
}