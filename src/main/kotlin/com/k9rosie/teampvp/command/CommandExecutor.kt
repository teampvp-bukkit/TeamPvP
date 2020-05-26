package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.util.sendPrettifiedMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.CommandExecutor as BukkitCmdExec

object CommandExecutor : BukkitCmdExec {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        var code = ErrorCode.UNKNOWN
        if (args.isEmpty()) return BaseCmd.prepare(sender, args) == ErrorCode.SUCCESS

        when (args[0]) {
            "test" -> code = TestCmd.prepare(sender, args.drop(1).toTypedArray())
        }

        if (code != ErrorCode.SUCCESS) {
            if (code == ErrorCode.UNKNOWN) {
                sender.sendPrettifiedMessage(ErrorCode.UNKNOWN.errNLS.parse(mapOf(":command" to args[0])))
            } else {
                sender.sendPrettifiedMessage(code.errNLS)
            }
        }

        return true
    }
}