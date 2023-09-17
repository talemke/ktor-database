package de.talemke.database

import org.jetbrains.exposed.sql.Database

fun createDatabase() = Database.connect("jdbc:h2:mem:regular", "org.h2.Driver")
