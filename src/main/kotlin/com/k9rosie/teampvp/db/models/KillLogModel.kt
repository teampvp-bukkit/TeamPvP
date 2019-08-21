package com.k9rosie.teampvp.db.models

import com.k9rosie.teampvp.db.tables.KillLogTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class KillLogModel(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<KillLogModel>(KillLogTable)
    var victim by KillLogTable.victim
    var attacker by KillLogTable.attacker
    var method by KillLogTable.method
    var time by KillLogTable.time
}