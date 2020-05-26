package com.k9rosie.teampvp

import com.k9rosie.teampvp.config.Config
import com.k9rosie.teampvp.config.CoreConfig

enum class NLS(private var yamlString: String) {
    PLUGIN_TAG("plugin_tag"),
    COMMAND_SUCCESS("command_success"),
    COMMAND_UNKNOWN("command_unknown"),
    COMMAND_PLAYER_ONLY("command_player_only"),
    COMMAND_NO_PERMISSION("command_no_permission"),
    COMMAND_REQUIRED_ARGS("command_required_args"),
    BASE_CMD_DESC("base_cmd_desc"),
    BASE_CMD_HELP_TXT("base_cmd_help_txt"),
    BASE_CMD_PARAMS_SUBCOMMAND("base_cmd_params_subcommand"),
    TEST_CMD_DESC("test_cmd_desc"),
    TEST_CMD_HELP_TXT("test_cmd_help_txt"),
    TEST_STRING("test_string"),
    PLAYER_NOT_FOUND("player_not_found"),
    WORLD_NONEXISTENT("world_nonexistent"),
    TIMER_ALREADY_STARTED("timer_already_started");

    fun parse(values: Map<String, Any>): String {
        var newString: String = toString()
        for (entry: Map.Entry<String, Any> in values) {
            newString = newString.replace(entry.key, entry.value.toString())
        }
        return newString
    }

    override fun toString(): String {
        return checkNotNull(config.yamlConfig.getString(yamlString))
    }

    companion object {
        val config = Config("nls/${CoreConfig.lang}.yml")
    }
}