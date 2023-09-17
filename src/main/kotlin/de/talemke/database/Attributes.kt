package de.talemke.database

import io.ktor.util.*

/**
 * This (application-wide) attribute stores the [DatabasePluginConfiguration].
 */
internal val databasePluginConfigurationKey: AttributeKey<DatabasePluginConfiguration>
	= AttributeKey("de.talemke:DatabasePluginConfiguration")
