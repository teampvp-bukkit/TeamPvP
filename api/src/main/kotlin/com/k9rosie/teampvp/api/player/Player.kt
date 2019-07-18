package com.k9rosie.teampvp.api.player

interface Player {
    /**
     * Returns the Bukkit Player object for this player.
     */
    fun getBukkitPlayer(): org.bukkit.entity.Player

    /**
     * Returns player statistics stored in db such as kills, deaths, etc.
     */
    fun getStatistics(): PlayerStatistics

    /**
     * Returns the current game state of the player. This is cleared and defaulted at the beginning of every game.
     */
    fun getState(): PlayerState

    /**
     * Returns the current flags that the player may have turned on or off, such as death messages.
     */
    fun getFlags(): PlayerFlags
}