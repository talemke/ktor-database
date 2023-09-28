package de.talemke.database

import org.jetbrains.exposed.sql.DatabaseConfig
import java.io.File

fun DatabasePluginConfigurator.addSQLite(file: File, configurator: DatabaseConfig.Builder.() -> Unit) {
	addDatabase {
		createSQLite(file, configurator)
	}
}

fun DatabasePluginConfigurator.addSQLite(key: String, file: File, configurator: DatabaseConfig.Builder.() -> Unit) {
	addDatabase(key) {
		createSQLite(file, configurator)
	}
}

inline fun <reified E : Enum<E>> DatabasePluginConfigurator.addSQLite(key: E, file: File, noinline configurator: DatabaseConfig.Builder.() -> Unit) {
	addDatabase(key) {
		createSQLite(file, configurator)
	}
}
