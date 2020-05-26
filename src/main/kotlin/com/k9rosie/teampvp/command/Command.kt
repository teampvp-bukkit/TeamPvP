package com.k9rosie.teampvp.command

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player as BukkitPlayer
import org.bukkit.permissions.Permission

abstract class Command {
    abstract val permission: String
    abstract val description: String
    abstract val playerOnly: Boolean
    abstract val helpText: String
    abstract val params: Array<Pair<String, Boolean>>
    abstract fun execute(sender: CommandSender, args: Map<String, String>): ErrorCode

    fun prepare(sender: CommandSender, args: Array<out String>): ErrorCode {
        if (playerOnly && sender !is BukkitPlayer) return ErrorCode.PLAYER_ONLY
        if (!sender.hasPermission(permission)) return ErrorCode.NO_PERMISSION

        // map arguments to available parameters
        val argMap: Map<String, String> = args.take(params.size).foldIndexed(mutableMapOf()) {
            index, map, element ->
            map[params[index].first] = element
            map
        }

        // check if all required params are satisfied
        for (pair in params) {
            if (argMap[pair.first] == null && pair.second) return ErrorCode.REQUIRED_ARGS
        }

        return execute(sender, argMap)
    }
}