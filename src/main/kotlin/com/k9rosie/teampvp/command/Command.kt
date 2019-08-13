package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.ErrorCode
import com.k9rosie.teampvp.util.TreeNode
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player as BukkitPlayer

abstract class Command {
    abstract val permission: String
    abstract val description: String
    abstract val playerOnly: Boolean
    abstract val helpText: String
    abstract val params: Array<Pair<String, Boolean>> // (name, required?)
    abstract fun execute(sender: CommandSender, map: Map<String, String>): Boolean

    fun prepare(sender: CommandSender, args: Array<out String>): ErrorCode {
        if (playerOnly && sender !is BukkitPlayer) return ErrorCode.COMMAND_PLAYER_ONLY
        if (!sender.hasPermission(permission)) return ErrorCode.COMMAND_NO_PERMISSION

        val paramMap = mutableMapOf<String, String>() // (name, value)
        for (i in 0 until args.size) {
            if (args[i] )
        }
        return execute(sender, paramMap)
    }
}