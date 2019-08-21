package com.k9rosie.teampvp.game

import com.k9rosie.teampvp.player.Player
import com.k9rosie.teampvp.player.PlayerState
import com.k9rosie.teampvp.team.Team
import com.k9rosie.teampvp.team.TeamState

class Game {
    enum class GameState { WAITING_FOR_PLAYERS, GAME_SETUP, GAME_STARTED, GAME_PAUSED, GAME_ENDED }

    companion object {
        var current: Game = newGame()

        fun newGame(): Game {
            var new = Game()
            current = new
            return new
        }

        infix fun register(player: Player) {
            val new = PlayerState(player, Team.defaultTeam)
        }

        infix fun register(team: Team) {
        }
    }

    val teamStates = hashMapOf<Team, TeamState>()
    val playerStates = hashMapOf<Player, PlayerState>()
    val gameState = GameState.WAITING_FOR_PLAYERS

    init {
    }
}