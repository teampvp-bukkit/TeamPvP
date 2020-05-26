package com.k9rosie.teampvp

import com.k9rosie.teampvp.command.CommandExecutor
import com.k9rosie.teampvp.config.TeamConfig
import com.k9rosie.teampvp.listener.PlayerListener
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin() {

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(PlayerListener, this);
        getCommand("pvp")?.setExecutor(CommandExecutor)
    }

    companion object {
        lateinit var instance: Plugin
    }
}
