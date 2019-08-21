package com.k9rosie.teampvp.player

import com.k9rosie.teampvp.team.Team

class PlayerState(val player: Player, val team: Team) {
    var dead = false
    var spectating = false
    var voted = false
    var shiftToggle = false
    var joinedCurrentGame = false
}