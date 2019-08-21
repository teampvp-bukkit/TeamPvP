package com.k9rosie.teampvp.db.tables

import com.k9rosie.teampvp.game.KillMethod
import org.jetbrains.exposed.dao.IntIdTable

object KillLogTable : IntIdTable() {
    val victim = reference("victim", PlayerTable).primaryKey(0)
    val attacker = reference("attacker", PlayerTable).primaryKey(1).nullable()
    val method = enumerationByName("method", 16, KillMethod::class)
    val time = datetime("time")
}