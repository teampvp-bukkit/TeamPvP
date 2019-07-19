package com.k9rosie.teampvp;

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getLogger().info("hello world");
    }
}