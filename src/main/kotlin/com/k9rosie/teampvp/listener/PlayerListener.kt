package com.k9rosie.teampvp.listener

import com.k9rosie.teampvp.NLS
import com.k9rosie.teampvp.util.sendPrettifiedMessage
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object PlayerListener : Listener {

    @EventHandler (priority = EventPriority.NORMAL)
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.player.sendPrettifiedMessage(NLS.TEST_STRING.toString());
    }
}