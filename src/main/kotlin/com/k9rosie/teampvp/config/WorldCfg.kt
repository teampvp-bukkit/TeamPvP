package com.k9rosie.teampvp.config

object WorldCfg : Config("worlds.yml") {
    val worlds = config.getConfigurationSection("worlds")
}