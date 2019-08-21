package com.k9rosie.teampvp.command

import com.k9rosie.teampvp.ErrorCode
import com.k9rosie.teampvp.events.PlayerInteract
import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.world.Region
import com.k9rosie.teampvp.world.World
import org.bukkit.command.CommandSender
import org.bukkit.event.block.Action
import org.bukkit.entity.Player as BukkitPlayer

object SetRegionCmd : Command() {
    override val description: String
        get() = "sets a region"

    override val helpText: String
        get() = "lad"

    override val params: Array<Pair<String, Boolean>>
        get() = arrayOf(
            Pair("region_name", true),
            Pair("region_type", true)
        )

    override val permission: String
        get() = "teampvp.cmd.admin.setregion"

    override val playerOnly: Boolean
        get() = true

    init {
        // event code for setting the region
        PlayerInteract on {
            val bukkitPlayer = it.event.player
            val player = Player.players[bukkitPlayer] ?: error("player does not exist in list")
            if (it.event.action == Action.LEFT_CLICK_BLOCK && it.event.clickedBlock != null
                && player.flags["settingRegion"] != null) {
                val region = player.flags["settingRegion"] as Region

                if (region.corner1 == null) {
                    region.corner1 = it.event.clickedBlock!!.location.clone() // we have to clone the location otherwise it'll just be passed as a reference
                    bukkitPlayer.sendMessage("Setting corner 2...")
                } else if (region.corner2 == null) {
                    region.corner2 = it.event.clickedBlock!!.location.clone()
                    region.save()
                    player.flags.remove("settingRegion")
                    bukkitPlayer.sendMessage("Region set!")
                }

                it.event.isCancelled = true
            }
        }
    }

    override fun execute(sender: CommandSender, args: Map<String, String>): ErrorCode {
        val name = args["region_name"] ?: error("region name was not included in args list")
        val regionType = Region.RegionType.valueOf(args["region_type"]?.toUpperCase() ?: return ErrorCode.REGION_TYPE_NONEXISTENT)

        val player = Player.players[sender as BukkitPlayer] ?: error("player does not exist in list")
        val world = World.worlds[player.bukkitPlayer.world.name] ?: error("world does not exist in list")
        val region = Region(name, regionType, null, null)
        world.regions[name] = region

        player.flags["settingRegion"] = region
        sender.sendMessage("Setting region...")

        return ErrorCode.COMMAND_SUCCESS
    }
}