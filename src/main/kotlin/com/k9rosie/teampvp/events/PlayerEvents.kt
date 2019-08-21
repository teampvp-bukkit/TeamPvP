package com.k9rosie.teampvp.events

import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent

data class PlayerJoin(val event: PlayerJoinEvent) {
    companion object : Event<PlayerJoin>()
    fun emit() = Companion.emit(this)
}

data class PlayerChat(val event: AsyncPlayerChatEvent) {
    companion object : Event<PlayerChat>()
    fun emit() = Companion.emit(this)
}

data class PlayerInteract(val event: PlayerInteractEvent) {
    companion object : Event<PlayerInteract>()
    fun emit() = Companion.emit(this)
}
