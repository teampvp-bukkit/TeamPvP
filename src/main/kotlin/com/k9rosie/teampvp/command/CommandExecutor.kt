package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.ErrorCode
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.CommandExecutor as BukkitCmdExec

object CommandExecutor : BukkitCmdExec {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        var code: ErrorCode = ErrorCode.COMMAND_UNKNOWN
        if (args.isEmpty()) return BaseCmd.prepare(sender, args) == ErrorCode.COMMAND_SUCCESS

        when (args[0]) {
            "test" -> code = TestCmd.prepare(sender, args.drop(1).toTypedArray())
        }

        if (code != ErrorCode.COMMAND_SUCCESS) sender.sendMessage(code.errTxt)
        return true
    }
}