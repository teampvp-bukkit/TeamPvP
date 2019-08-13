package com.k9rosie.teampvp

enum class ErrorCode(val errTxt: String) {
    COMMAND_FAILED("An internal error occurred while processing your command: @error"),
    COMMAND_REQUIRED_ARGS("You need to supply an argument for the @param parameter"),
    COMMAND_NO_PERMISSION("You don't have permission to run that command"),
    COMMAND_PLAYER_ONLY("Only players can execute this command"),
    COMMAND_SUCCESS("")

}