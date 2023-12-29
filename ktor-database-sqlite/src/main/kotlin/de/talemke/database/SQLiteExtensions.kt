package de.talemke.database

import org.jetbrains.exposed.sql.DatabaseConfig
import java.io.File

/**
 * Adds an SQLite database.
 *
 * @param file the database file
 * @param configurator optional configuration
 */
fun DatabasePluginConfigurator.addSQLite(file: File, configurator: DatabaseConfig.Builder.() -> Unit) {
	addDatabase {
		createSQLite(file, configurator)
	}
}

/**
 * Adds an SQLite database with the specified key.
 *
 * @param key the database key
 * @param file the database file
 * @param configurator optional configuration
 */
fun DatabasePluginConfigurator.addSQLite(key: String, file: File, configurator: DatabaseConfig.Builder.() -> Unit) {
	addDatabase(key) {
		createSQLite(file, configurator)
	}
}

/**
 * Adds an SQLite database with the specified key.
 *
 * @param key the database key
 * @param file the database file
 * @param configurator optional configuration
 */
inline fun <reified E : Enum<E>> DatabasePluginConfigurator.addSQLite(key: E, file: File, noinline configurator: DatabaseConfig.Builder.() -> Unit) {
	addDatabase(key) {
		createSQLite(file, configurator)
	}
}
