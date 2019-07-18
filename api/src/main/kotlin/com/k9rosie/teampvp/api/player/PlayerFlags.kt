package com.k9rosie.teampvp.api.player

interface PlayerFlags {
    /**
     * Returns the value of the deathMessages flag, which determines whether or not
     * the player can see death messages in chat.
     */
    fun hasDeathMessagesEnabled(): Boolean

    /**
     * Returns the value of the teamChat flag, which determines whether or not
     * the player is currently typing in their team's chat
     */
    fun hasTeamChatEnabled(): Boolean

    /**
     * Returns the value of the settingRegion flag, which determines whether or not
     * the player is currently setting a region. This is used to slightly alter
     * game play for the player currently setting the region
     */
    fun isSettingRegion(): Boolean

    /**
     * Sets the deathMessages flag with a specified value
     * Refer to hasDeathMessagesEnabled().
     */
    fun setDeathMessagesFlag(deathMessages: Boolean)

    /**
     * Sets the teamChat flag with a specified value
     * Refer to hasTeamChatEnabled().
     */
    fun setTeamChatFlag(teamChat: Boolean)

    /**
     * Sets the settingRegions flag with a specified value
     * Refer to isSettingRegion().
     */
    fun setSettingRegionsFlag(settingRegion: Boolean)
}