package com.k9rosie.teampvp.command.admin

import com.k9rosie.teampvp.Player
import com.k9rosie.teampvp.Team
import com.k9rosie.teampvp.command.Command
import org.bukkit.command.CommandSender

class SetTeamCmd(sender: CommandSender, val player: Player, val team: Team) : Command(sender) {
    override val permission: String
        get() = "teampvp.cmd.admin.setteam"

    override val description: String
        get() = "Sets the team of a player"

    override val playerOnly: Boolean
        get() = false

    override val helpText: String
        get() = """
            Usage: setteam player_name team_name
        """.trimIndent()
}