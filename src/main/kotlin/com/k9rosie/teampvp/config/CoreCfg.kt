package com.k9rosie.teampvp.config

object CoreCfg : Config("config.yml") {
    val debug = config.getBoolean("debug")
    val dbSettings = config.getConfigurationSection("database")
        ?: error("database section in core.yml is nonexistent")
    val worldSettings = config.getConfigurationSection("world")
        ?: error("world section in core.yml is nonexistent")
    val gameSettings = config.getConfigurationSection("game")
        ?: error("game section in core.yml is nonexistent")
    val effectSettings = config.getConfigurationSection("effects")
        ?: error("effects section in core.yml is nonexistent")
}