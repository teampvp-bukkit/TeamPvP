package com.k9rosie.teampvp

class Game(val world: World) {
    var phase: GamePhase = GamePhase.WAITING_FOR_PLAYERS

    enum class GamePhase {
        WAITING_FOR_PLAYERS,
        SETUP,
        STARTED,
        ENDED
    }

    companion object {
        var current: Game = Game()
    }
}
