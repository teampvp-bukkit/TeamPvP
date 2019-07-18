package com.k9rosie.teampvp.api.player

import com.k9rosie.teampvp.api.game.GameInstance

interface PlayerState {

    fun getGame(): GameInstance
}