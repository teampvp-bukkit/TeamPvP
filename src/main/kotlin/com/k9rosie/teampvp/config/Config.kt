package com.k9rosie.teampvp.config

import com.k9rosie.teampvp.Plugin
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.InputStreamReader

abstract class Config(private val name: String) {

    private val file = File(Plugin.dataFolder, name)
    var config: YamlConfiguration = YamlConfiguration.loadConfiguration(file)

    init {
        reload()
    }

    fun reload() {
        config = YamlConfiguration.loadConfiguration(file)

        // load our defaults from the jar into memory as a reference, in case some values are missing or invalid
        val default = YamlConfiguration.loadConfiguration(InputStreamReader(Plugin.getResource(name)))
        config.setDefaults(default)
    }

    fun save() = if (file.isFile) config.save(file) else Plugin.saveResource(name, false)
}