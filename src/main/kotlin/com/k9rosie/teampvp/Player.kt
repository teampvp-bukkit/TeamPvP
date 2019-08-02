package com.k9rosie.teampvp
import org.bukkit.Bukkit
import org.bukkit.entity.Player as BukkitPlayer

class Player(player: BukkitPlayer) {
    companion object Factory {
        private val players = hashMapOf<BukkitPlayer, Player>()

        fun fromUsername(username: String) : Player? = players[Bukkit.getPlayer(username)]
        fun create(player: BukkitPlayer) {

        }
    }
}