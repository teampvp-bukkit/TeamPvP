package com.k9rosie.teampvp.models

import org.jetbrains.exposed.sql.Table

object Player : Table() {
    val id = varchar("id", 10).primaryKey()
}