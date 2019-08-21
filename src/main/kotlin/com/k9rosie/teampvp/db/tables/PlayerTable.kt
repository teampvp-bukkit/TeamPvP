package com.k9rosie.teampvp.db.tables

import org.jetbrains.exposed.dao.UUIDTable

object PlayerTable : UUIDTable() {
    val username = varchar("username", 16)
    val kills = integer("kills")
    val projectileKills = integer("projectile_kills")
    val deaths = integer("deaths")
    val projectileDeaths = integer("projectile_deaths")
    val suicides = integer("suicides")
    val assists = integer("assists")
    val damageGiven = integer("damage_given")
    val damageTaken = integer("damage_taken")
    val wins = integer("wins")
    val losses = integer("losses")
    val totalTime = long("total_time")
    val firstJoined = datetime("first_joined")
    val lastOnline = datetime("last_online")
}