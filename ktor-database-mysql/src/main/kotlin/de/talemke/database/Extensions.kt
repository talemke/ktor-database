package de.talemke.database

import com.zaxxer.hikari.HikariConfig

fun DatabasePluginConfigurator.addMySQL(hostname: String, database: String, configurator: HikariConfig.() -> Unit) {
	addDatabase {
		createMySQL(hostname, database, configurator)
	}
}

fun DatabasePluginConfigurator.addMySQL(key: String, hostname: String, database: String, configurator: HikariConfig.() -> Unit) {
	addDatabase(key) {
		createMySQL(hostname, database, configurator)
	}
}

inline fun <reified E : Enum<E>> DatabasePluginConfigurator.addMySQL(key: E, hostname: String, database: String, configurator: HikariConfig.() -> Unit) {
	addDatabase(key) {
		createMySQL(hostname, database, configurator)
	}
}
