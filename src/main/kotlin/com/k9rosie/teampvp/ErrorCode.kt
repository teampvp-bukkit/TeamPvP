package com.k9rosie.teampvp

enum class ErrorCode(val errTxt: String) {
    COMMAND_UNKNOWN("Unknown command. Type /pvp help for more information"),
    COMMAND_REQUIRED_ARGS("Insufficient arguments"),
    COMMAND_NO_PERMISSION("You don't have permission to run that command"),
    COMMAND_PLAYER_ONLY("Only players can execute this command"),
    COMMAND_SUCCESS(""),
    REGION_TYPE_NONEXISTENT("The region type you entered is not applicable.");

    override fun toString(): String {
        return errTxt
    }
}