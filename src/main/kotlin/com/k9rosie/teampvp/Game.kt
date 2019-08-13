package com.k9rosie.teampvp

class Game {
    companion object {
        var instance: Game = create()

        fun create() = Game()
    }
}