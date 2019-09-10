package com.k9rosie.teampvp.gamemode

import com.k9rosie.teampvp.Plugin
import org.bukkit.event.Listener

abstract class Gamemode(val name: String) {
    var enabled: Boolean = false
    lateinit var pvpPlugin: Plugin
    abstract var listeners: List<Listener>

    abstract fun onEnable()
    abstract fun onDisable()
}