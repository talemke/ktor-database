package de.talemke.database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.DatabaseConfig
import java.io.File
import java.sql.Connection

/**
 * The SQLite driver class.
 */
@PublishedApi
internal const val SQLITE_DRIVER = "org.sqlite.JDBC"

/**
 * Creates a new SQLite database with the given backing file.
 *
 * **Note:** This does not *immediately* establish a connection, only when it is first used.
 *
 * @param file the backing file
 * @param configurator optional configuration
 * @return the created [Database]
 */
fun createSQLite(file: File, configurator: DatabaseConfig.Builder.() -> Unit = {}): Database {
	// Ensure parent folder exists
	if (!file.parentFile.isDirectory) {
		file.parentFile.mkdirs()
	}

	// Create database connection
	val config = DatabaseConfig {
		defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
		configurator(this)
	}
	return Database.connect("jdbc:sqlite:$file", SQLITE_DRIVER, databaseConfig = config)
}
