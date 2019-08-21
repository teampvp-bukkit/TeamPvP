package com.k9rosie.teampvp.listeners

import com.k9rosie.teampvp.events.PlayerInteract
import com.k9rosie.teampvp.events.PlayerJoin
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent

object PlayerListener : Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    fun onPlayerJoin(event: PlayerJoinEvent) = PlayerJoin(event).emit()

    @EventHandler(priority = EventPriority.NORMAL)
    fun onPlayerInteract(event: PlayerInteractEvent) = PlayerInteract(event).emit()
}