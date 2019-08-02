package com.k9rosie.teampvp.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.CommandExecutor as BukkitCmdExec

object CommandExecutor : BukkitCmdExec {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        var command = Command(sender, args)
        when ()
    }
}