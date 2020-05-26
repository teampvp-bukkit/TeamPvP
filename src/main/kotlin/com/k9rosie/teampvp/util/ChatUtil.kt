package com.k9rosie.teampvp.util

import com.k9rosie.teampvp.NLS
import org.bukkit.Bukkit
import org.bukkit.entity.Player as BukkitPlayer
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import java.util.logging.Logger

fun colorize(str: String): String {
    return ChatColor.translateAlternateColorCodes('&', str)
}

fun CommandSender.sendPrettifiedMessage(msg: String) {
    this.sendMessage(colorize(NLS.PLUGIN_TAG.toString() + msg))
}

fun CommandSender.sendPrettifiedMessage(nls: NLS) {
    this.sendMessage(colorize(NLS.PLUGIN_TAG.toString() + nls.toString()))
}

fun BukkitPlayer.sendPrettifiedMessage(msg: String) {
    this.sendMessage(colorize(NLS.PLUGIN_TAG.toString() + msg))
}

fun BukkitPlayer.sendPrettifiedMessage(nls: NLS) {
    this.sendMessage(colorize(NLS.PLUGIN_TAG.toString() + nls.toString()))
}

fun Bukkit.broadcastPrettifiedMessage(msg: String) {
    Bukkit.broadcastMessage(colorize(NLS.PLUGIN_TAG.toString() + msg))
}

fun Bukkit.broadcastPrettifiedMessage(nls: NLS) {
    Bukkit.broadcastMessage(colorize(NLS.PLUGIN_TAG.toString() + nls.toString()))
}

fun Logger.severe(nls: NLS) {
    Bukkit.getLogger().severe(nls.toString())
}
