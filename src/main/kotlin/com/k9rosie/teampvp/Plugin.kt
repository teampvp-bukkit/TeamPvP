package com.k9rosie.teampvp

import com.k9rosie.teampvp.command.CommandExecutor
import com.k9rosie.teampvp.config.CoreCfg
import com.k9rosie.teampvp.events.InitEvent
import com.k9rosie.teampvp.game.Gamemode
import com.k9rosie.teampvp.listeners.PlayerListener
import com.k9rosie.teampvp.util.RepeatingTask
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.exposed.sql.Database

class Plugin : JavaPlugin() {
    companion object {
        lateinit var instance: Plugin
        val gamemodes: Map<String, Gamemode> = hashMapOf()
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.callEvent(InitEvent(this))

        // set up hikari and connect to the database
        val hikariConfig = HikariConfig()
        val connector = CoreCfg.dbSettings?.getString("connector")
        val url = CoreCfg.dbSettings?.getString("url")
        hikariConfig.jdbcUrl = "jdbc:$connector:$url"

        if (!connector.equals("sqlite", ignoreCase = true)) {
            hikariConfig.username = CoreCfg.dbSettings?.getString("remote.username")
            hikariConfig.password = CoreCfg.dbSettings?.getString("remote.password")
        }

        Database.connect(HikariDataSource(hikariConfig))

        getCommand("pvp")?.setExecutor(CommandExecutor)
        server.pluginManager.registerEvents(PlayerListener, this)

        val testTimer = RepeatingTask(20) {
            print("test")
        }
    }
}