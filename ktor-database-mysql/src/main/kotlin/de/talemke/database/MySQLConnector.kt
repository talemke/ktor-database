package de.talemke.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

/**
 * The MySQL driver class.
 */
@PublishedApi
internal const val MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver"

/**
 * Creates a new MySQL database.
 *
 * **Note:** This does not *immediately* establish a connection, only when it is first used.
 *
 * **Note:** You probably need to set the [HikariConfig.username] and [HikariConfig.password] fields.
 */
inline fun createMySQL(hostname: String, database: String, configurator: HikariConfig.() -> Unit): Database {
	val config = HikariConfig().also {
		it.jdbcUrl = "jdbc:mysql://$hostname/$database"
		it.driverClassName = MYSQL_DRIVER
	}.also(configurator)
	return HikariDataSource(config).let(Database::connect)
}
