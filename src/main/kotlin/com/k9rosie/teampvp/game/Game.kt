package com.k9rosie.teampvp.game

import com.k9rosie.teampvp.Plugin
import com.k9rosie.teampvp.config.WorldCfg
import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.player.PlayerState
import com.k9rosie.teampvp.team.Team
import com.k9rosie.teampvp.team.TeamState
import com.k9rosie.teampvp.world.World
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.attribute.Attribute

class Game(val world: World) {
    companion object {
        // when the plugin first initializes the Game singleton,
        // we'll pull a random world and use that as our first
        var current: Game = Game(World.all.values.random())

        fun new(world: World): Game {
            current.cleanup()
            current = Game(world)
            return current
        }
    }

    val gamemode: Gamemode = Plugin.gamemodes[WorldCfg.worlds?.getString("${world.name}.gamemode")]
        ?: DefaultGamemode
    val teams = hashMapOf<Team, TeamState>()
    val players = hashMapOf<Player, PlayerState>()
    val phase = GamePhase.WAITING_FOR_PLAYERS
    val scoreboard = Scoreboard()

    init {
        // get the our gamemode and teams defined in worlds.yml
        // set the gamemode and register our team
        WorldCfg.worlds.getStringList("${world.name}.enabled_teams").forEach {
            val team = Team.all[it]
                ?: error("team '$it' for ${world.name} in world.yml doesn't exist. Are you sure " +
                        "it's defined in teams.yml?")
            register(team)
            scoreboard.register(team)
        }

        // next, get all of our players in the game and register (create new player states) for them
        // then, do bukkit functions on them (teleport them to lobby, set health, etc.)
        Player.all.values.forEach {
            register(it)
            it.bukkitPlayer.teleport(World.lobbyWorld.spawns[Team.defaultTeam]
                ?: error("tried to teleport players to the lobby world when there was no spawn set there. " +
                        "Remember to set spawn for the default team to the lobby world."))
            it.bukkitPlayer.gameMode = GameMode.SURVIVAL
            it.bukkitPlayer.health = it.bukkitPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.value ?: 20.0
            it.bukkitPlayer.foodLevel = 20
        }

        world.reloadBattlefields()

    }

    fun register(player: Player) {
        val new = PlayerState(player, Team.defaultTeam)
        player.state = new
        current.players[player] = new
    }

    fun register(team: Team) {
        val new = TeamState(team, scoreboard.registerNewTeam(team.name))
        team.state = new
        current.teams[team] = new
    }

    fun cleanup() {

    }

    enum class GamePhase { WAITING_FOR_PLAYERS, GAME_SETUP, GAME_STARTED, GAME_PAUSED, GAME_ENDED }
}