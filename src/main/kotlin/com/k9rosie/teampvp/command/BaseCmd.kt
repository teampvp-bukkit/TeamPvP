package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.ErrorCode
import org.bukkit.command.CommandSender

object BaseCmd : Command() {
    override val description: String
        get() = "Base TeamPvP command"

    override val helpText: String
        get() = "dude weed lmao"

    override val params: Array<Pair<String, Boolean>>
        get() = arrayOf(
            Pair("subcommand", false)
        )

    override val permission: String
        get() = "teampvp.cmd"

    override val playerOnly: Boolean
        get() = false

    override fun execute(sender: CommandSender, args: Map<String, String>): ErrorCode {
        sender.sendMessage("whaddup")
        return ErrorCode.COMMAND_SUCCESS
    }
}