package com.k9rosie.teampvp.config

object CoreConfig : Config("config.yml") {
    val debug = yamlConfig.getBoolean("debug")
    val lang = yamlConfig.getString("lang")

    // in places with non-null assertion: defaults will hopefully fill any gaps.
    // if there are no defaults then there is a mistake in the default yaml config or in the
    // yaml string path below.
    val database = DatabaseSettings(
        yamlConfig.getString("database.connector")!!,
        yamlConfig.getString("database.url")!!,
        yamlConfig.getString("database.remote.username")!!,
        yamlConfig.getString("database.remote.password")!!
    )
    val world = WorldSettings(
        yamlConfig.getStringList("world.enabled"),
        yamlConfig.getString("world.lobby")!!,
        yamlConfig.getBoolean("world.votingEnabled")
    )
    val game = GameSettings(
        yamlConfig.getInt("game.minimum_players"),
        yamlConfig.getInt("game.largest_team_imbalance"),
        yamlConfig.getInt("game.rebalance_warning_timer"),
        yamlConfig.getBoolean("game.join_in_progress"),
        yamlConfig.getInt("game.pre_game_timer"),
        yamlConfig.getInt("game.post_game_timer"),
        yamlConfig.getInt("game.respawn_timer"),
        yamlConfig.getBoolean("game.enable_hunger"),
        yamlConfig.getBoolean("game.health_regen"),
        yamlConfig.getInt("game.assist_timer"),
        yamlConfig.getString("game.default_team.name")!!,
        yamlConfig.getString("game.default_team.color")!!,
        yamlConfig.getBoolean("game.default_team.can_attack"),
        yamlConfig.getBoolean("game.default_team.can_be_damaged"),
        yamlConfig.getBoolean("game.deault_team.friendly_fire")
    )
    val effects = EffectsSettings(
        yamlConfig.getString("effects.death.particle.type")!!,
        yamlConfig.getInt("effects.death.particle.count"),
        yamlConfig.getString("effects.death.sound.type")!!,
        yamlConfig.getDouble("effects.death.sound.volume"),
        yamlConfig.getDouble("effects.death.sound.pitch"),
        yamlConfig.getString("effects.respawn.particle.type")!!,
        yamlConfig.getInt("effects.respawn.particle.count"),
        yamlConfig.getString("effects.respawn.sound.type")!!,
        yamlConfig.getDouble("effects.respawn.sound.volume"),
        yamlConfig.getDouble("effects.respawn.sound.pitch")
    )

    class DatabaseSettings(
        val connector: String,
        val url: String,
        val username: String,
        val password: String
    )

    class WorldSettings(
        val enabledWorlds: MutableList<String>,
        val lobby: String,
        val votingEnabled: Boolean
    )

    class GameSettings(
        val minimumPlayers: Int,
        val largestTeamImbalance: Int,
        val rebalanceWarningTimer: Int,
        val joinInProgress: Boolean,
        val preGameTimer: Int,
        val postGameTimer: Int,
        val respawnTimer: Int,
        val enableHunger: Boolean,
        val healthRegen: Boolean,
        val assistTimer: Int,
        val defaultTeamName: String,
        val defaultTeamColor: String,
        val defaultTeamCanAttack: Boolean,
        val defaultTeamCanBeDamaged: Boolean,
        val defaultTeamFriendlyFire: Boolean
    )

    class EffectsSettings(
        val deathParticleType: String,
        val deathParticleCount: Int,
        val deathSoundType: String,
        val deathSoundVolume: Double,
        val deathSoundPitch: Double,
        val respawnParticleType: String,
        val respawnParticleCount: Int,
        val respawnSoundType: String,
        val respawnSoundVolume: Double,
        val respawnSoundPitch: Double
    )

}
