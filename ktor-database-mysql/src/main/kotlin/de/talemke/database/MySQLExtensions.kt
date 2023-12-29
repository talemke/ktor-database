package de.talemke.database

import com.zaxxer.hikari.HikariConfig

/**
 * Adds a remote MySQL database.
 *
 * @param hostname the hostname of the server
 * @param database the database name
 * @param configurator further configuration
 */
fun DatabasePluginConfigurator.addMySQL(hostname: String, database: String, configurator: HikariConfig.() -> Unit) {
	addDatabase {
		createMySQL(hostname, database, configurator)
	}
}

/**
 * Adds a remote MySQL database with the given key.
 *
 * @param key the database key
 * @param hostname the hostname of the server
 * @param database the database name
 * @param configurator further configuration
 */
fun DatabasePluginConfigurator.addMySQL(key: String, hostname: String, database: String, configurator: HikariConfig.() -> Unit) {
	addDatabase(key) {
		createMySQL(hostname, database, configurator)
	}
}

/**
 * Adds a remote MySQL database with the given key.
 *
 * @param key the database key
 * @param hostname the hostname of the server
 * @param database the database name
 * @param configurator further configuration
 */
inline fun <reified E : Enum<E>> DatabasePluginConfigurator.addMySQL(key: E, hostname: String, database: String, configurator: HikariConfig.() -> Unit) {
	addDatabase(key) {
		createMySQL(hostname, database, configurator)
	}
}
