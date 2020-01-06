package com.k9rosie.teampvp.events

import com.k9rosie.teampvp.Plugin
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class InitEvent(var plugin: Plugin) : Event() {
    companion object {
        var handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList
}