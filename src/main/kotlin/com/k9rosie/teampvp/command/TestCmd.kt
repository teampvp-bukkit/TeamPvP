package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.NLS
import com.k9rosie.teampvp.util.sendPrettifiedMessage
import org.bukkit.command.CommandSender

object TestCmd : Command() {
    override val permission: String
        get() = "teampvp.cmd.test"
    override val description: String
        get() = NLS.TEST_CMD_DESC.toString()
    override val playerOnly: Boolean
        get() = true
    override val helpText: String
        get() = NLS.TEST_CMD_HELP_TXT.toString()
    override val params: Array<Pair<String, Boolean>>
        get() = arrayOf()

    override fun execute(sender: CommandSender, args: Map<String, String>): ErrorCode {
        sender.sendPrettifiedMessage(NLS.PLAYER_NOT_FOUND.parse(mapOf(":username" to sender.name)))
        return ErrorCode.SUCCESS
    }

}