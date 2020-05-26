package com.k9rosie.teampvp.config

import com.k9rosie.teampvp.Plugin
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.InputStreamReader

open class Config(private val name: String) {
    private val file = File(Plugin.instance.dataFolder, name)
    lateinit var yamlConfig: YamlConfiguration

    init {
        if (!file.isFile) Plugin.instance.saveResource(name, false)

        load()
        yamlConfig.setDefaults(YamlConfiguration.loadConfiguration(InputStreamReader(checkNotNull(Plugin.instance.getResource(name)))))
    }

    fun load() { yamlConfig = YamlConfiguration.loadConfiguration(file) }

    fun save() { if (file.isFile) yamlConfig.save(file) else Plugin.instance.saveResource(name, false) }
}