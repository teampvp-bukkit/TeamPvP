package com.k9rosie.teampvp.command

class HelpCmd : Command() {
    override val description: String
        get() = "This command"

    override val helpText: String
        get() = "help <command name>"
}