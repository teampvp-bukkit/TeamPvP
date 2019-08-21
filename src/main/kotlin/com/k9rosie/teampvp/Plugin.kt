package com.k9rosie.teampvp

import com.k9rosie.teampvp.command.CommandExecutor
import com.k9rosie.teampvp.config.CoreCfg
import com.k9rosie.teampvp.listeners.PlayerListener
import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.world.World
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.exposed.sql.Database

class Plugin : JavaPlugin() {
    companion object {
        var instance: Plugin? = null
        private set
    }

    override fun onEnable() {
        instance = this

        // set up hikari and connect to the database
        val hikariConfig = HikariConfig()
        val connector = CoreCfg.dbSettings?.getString("connector")
        val url = CoreCfg.dbSettings?.getString("url")
        val username = CoreCfg.dbSettings?.getString("remote.username")
        val password = CoreCfg.dbSettings?.getString("remote.password")
        hikariConfig.jdbcUrl = "jdbc:$connector:$url"

        if (!connector.equals("sqlite", ignoreCase = true)) {
            hikariConfig.username = username
            hikariConfig.password = password
        }

        Database.connect(HikariDataSource(hikariConfig))
        getCommand("pvp")?.setExecutor(CommandExecutor)
        server.pluginManager.registerEvents(PlayerListener, this)
        World.create("world", Bukkit.getWorld("world") ?: error("no world named world"))
        Player.Companion // initialize companion object before first player joins the game
    }
}