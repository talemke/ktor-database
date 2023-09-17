package de.talemke.database

import org.jetbrains.exposed.sql.Database

internal data class DatabasePluginConfiguration(
	val defaultDatabaseKey: String?,
	val database: Database?,
	val databases: Map<String, Database>,
) {

	operator fun get(key: String?) = key?.let(databases::get) ?: database

}
