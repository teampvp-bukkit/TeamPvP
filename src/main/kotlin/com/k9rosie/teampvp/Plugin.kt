package com.k9rosie.teampvp;

import com.k9rosie.teampvp.command.CommandExecutor
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

object Plugin : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getLogger().info("hello world")
        getCommand("teampvp").setExecutor(CommandExecutor)
    }
}