package de.talemke.database

import org.jetbrains.exposed.sql.Database

class DatabasePluginConfigurator internal constructor() {

	private var defaultDatabaseKey: String? = null
	private var database: Database? = null
	private val databases: MutableMap<String, Database> = mutableMapOf()



	fun addDatabase(db: Database) {
		if (this.database != null) {
			throw IllegalStateException("Another database with no key has already been added.")
		}
		this.database = db
	}

	fun addDatabase(key: String, db: Database) {
		this.databases[key] = db
	}

	inline fun <reified E : Enum<E>> addDatabase(key: E, db: Database) {
		addDatabase(key.toDatabaseKey(), db)
	}



	internal fun validate() = DatabasePluginConfiguration(
		defaultDatabaseKey = defaultDatabaseKey,
		database = database,
		databases = databases.toMap(),
	)

}
