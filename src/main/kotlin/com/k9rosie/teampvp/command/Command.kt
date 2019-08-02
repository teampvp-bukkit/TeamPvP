package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.util.TreeNode
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player as BukkitPlayer

abstract class Command(private val sender: CommandSender) {
    abstract val permission: String
    abstract val description: String
    abstract val playerOnly: Boolean
    abstract val helpText: String
    abstract fun execute(): Boolean

    fun prepare(): Boolean {
        if (playerOnly && sender !is BukkitPlayer) return false
        if (execute()) return true
        return false
    }
}