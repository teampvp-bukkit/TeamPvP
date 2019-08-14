package com.k9rosie.teampvp.config

object CoreCfg : Config("config.yml") {
    val debug = config.getBoolean("debug")
    val dbSettings = config.getConfigurationSection("database")
    val worldSettings = config.getConfigurationSection("world")
    val gameSettings = config.getConfigurationSection("game")
    val effectSettings = config.getConfigurationSection("effects")
}