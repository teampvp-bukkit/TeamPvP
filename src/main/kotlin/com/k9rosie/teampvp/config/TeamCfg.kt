package com.k9rosie.teampvp.config

object TeamCfg : Config("teams.yml") {
    val teams = config.getMapList("teams")
}