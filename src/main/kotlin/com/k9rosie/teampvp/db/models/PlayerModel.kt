package com.k9rosie.teampvp.db.models

import com.k9rosie.teampvp.db.tables.PlayerTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import java.util.UUID

class PlayerModel(uuid: EntityID<UUID>) : UUIDEntity(uuid) {
    companion object : UUIDEntityClass<PlayerModel>(PlayerTable)
    var username by PlayerTable.username
    var kills by PlayerTable.kills
    var projectileKills by PlayerTable.projectileKills
    var deaths by PlayerTable.deaths
    var projectileDeaths by PlayerTable.projectileDeaths
    var suicides by PlayerTable.suicides
    var assists by PlayerTable.assists
    var damageGiven by PlayerTable.damageGiven
    var damageTaken by PlayerTable.damageTaken
    var wins by PlayerTable.wins
    var losses by PlayerTable.losses
    var totalTime by PlayerTable.totalTime
    var firstJoined by PlayerTable.firstJoined
    var lastOnline by PlayerTable.lastOnline
}