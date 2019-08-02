package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.util.TreeNode
import org.bukkit.command.CommandSender


class BaseCmd(sender: CommandSender, val subcommand: String = "") : Command(sender) {
    override val permission: String
        get() = "teampvp.cmd"

    override val description: String
        get() = "The base TeamPvP command"

    override val playerOnly: Boolean
        get() = false

    override val helpText: String
        get() = """
            Available commands:
            - admin [command] (for admins only, type /pvp help admin for more info)
            - chat | c [channel]
            - deathmessages | dm [on | off]
            - help [command]
            - join [team]
            - leave
            - map
            - player [player]
            - spectate [player]
            - team [team]
            - vote map_num | map_name
        """.trimIndent()

    override fun execute(): Boolean {

    }
}