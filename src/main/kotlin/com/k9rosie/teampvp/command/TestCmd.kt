package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.ErrorCode
import org.bukkit.command.CommandSender

object TestCmd : Command() {
    override val description: String
        get() = "A test command"

    override val helpText: String
        get() = "It's just a test command dude"

    override val params: Array<Pair<String, Boolean>>
        get() = arrayOf(
            Pair("foo", true),
            Pair("bar", true),
            Pair("baz", false)
        )

    override val permission: String
        get() = "novswar.cmd.test"

    override val playerOnly: Boolean
        get() = false

    override fun execute(sender: CommandSender, args: Map<String, String>): ErrorCode {
        sender.sendMessage("${args["foo"]} ${args["bar"]} ${args["baz"]}")
        return ErrorCode.COMMAND_SUCCESS
    }
}