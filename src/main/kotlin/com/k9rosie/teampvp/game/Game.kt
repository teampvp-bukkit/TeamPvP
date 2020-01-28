package com.k9rosie.teampvp.game

import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.player.PlayerState
import com.k9rosie.teampvp.team.Team
import com.k9rosie.teampvp.team.TeamState
import com.k9rosie.teampvp.world.World
import org.bukkit.Bukkit

class Game(val world: World, val gamemode: Gamemode = world.gamemode) {
    enum class GamePhase { WAITING_FOR_PLAYERS, GAME_SETUP, GAME_STARTED, GAME_PAUSED, GAME_ENDED }

    companion object {
        var current: Game = Game(World.all.toList()[0].second) // get the first world

        fun new(world: World) {
            current = Game(world)
        }
    }

    val teamStates = hashMapOf<Team, TeamState>()
    val playerStates = hashMapOf<Player, PlayerState>()
    val phase = GamePhase.WAITING_FOR_PLAYERS
    val scoreboard = Bukkit.getScoreboardManager()?.newScoreboard ?: throw Exception("first world hasn't loaded")

    init {

    }

    fun register(player: Player) {
        val new = PlayerState(player, Team.defaultTeam)
        player.state = new
        current.playerStates[player] = new
    }

    fun register(team: Team) {
        val new = TeamState(team, scoreboard.registerNewTeam(team.name))
        team.state = new
        current.teamStates[team] = new
    }
}