package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.ErrorCode
import com.k9rosie.teampvp.world.World
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object RevertRegionCmd : Command() {
    override val description: String
        get() = "asdf"

    override val helpText: String
        get() = "dasf"

    override val params: Array<Pair<String, Boolean>>
        get() = arrayOf(
            Pair("region_name", true)
        )

    override val permission: String
        get() = "teampvp.cmd.admin.revertregion"

    override val playerOnly: Boolean
        get() = true

    override fun execute(sender: CommandSender, args: Map<String, String>): ErrorCode {
        val player = sender as Player
        val world = World.all[player.world.name]
        val region = world?.regions?.get(args["region_name"])
        if (region != null) {
            sender.sendMessage("Reverting ${region.blocks.size} blocks")

            world.regions[args["region_name"]]?.revert()
            return ErrorCode.COMMAND_SUCCESS
        }
        return ErrorCode.COMMAND_UNKNOWN
    }
}