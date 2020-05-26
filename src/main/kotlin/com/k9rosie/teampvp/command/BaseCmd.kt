package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.NLS
import com.k9rosie.teampvp.util.sendPrettifiedMessage
import org.bukkit.command.CommandSender
import org.bukkit.permissions.Permission

object BaseCmd : Command() {
    override val permission: String
        get() = "teampvp.cmd"
    override val description: String
        get() = NLS.BASE_CMD_DESC.toString()
    override val playerOnly: Boolean
        get() = false
    override val helpText: String
        get() = NLS.BASE_CMD_HELP_TXT.toString()
    override val params: Array<Pair<String, Boolean>>
        get() = arrayOf(
            Pair(NLS.BASE_CMD_PARAMS_SUBCOMMAND.toString(), false)
        )

    override fun execute(sender: CommandSender, args: Map<String, String>): ErrorCode {
        sender.sendPrettifiedMessage(NLS.TEST_STRING)
        return ErrorCode.SUCCESS
    }

}
