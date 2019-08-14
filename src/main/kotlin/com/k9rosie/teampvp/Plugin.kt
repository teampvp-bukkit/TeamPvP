package com.k9rosie.teampvp;

import com.k9rosie.teampvp.command.CommandExecutor
import com.k9rosie.teampvp.config.CoreCfg
import com.k9rosie.teampvp.models.Player
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class Plugin : JavaPlugin() {
    companion object {
        var instance: Plugin? = null
        private set;
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
    }


}