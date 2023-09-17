package de.talemke.database

import io.ktor.server.application.*

/**
 * The database plugin.
 * Allows [ApplicationCall]s to execute transactions while also producing metrics for different endpoints.
 *
 * @see <a href="https://github.com/talemke/ktor-database">https://github.com/talemke/ktor-database</a>
 */
val Database = createApplicationPlugin("de.talemke:DatabasePlugin", ::DatabasePluginConfigurator) {
	// Validate configuration and store application-wide
	val config = pluginConfig.validate()
	application.attributes.put(databasePluginConfigurationKey, config)
}
