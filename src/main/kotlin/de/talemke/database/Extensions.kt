package de.talemke.database

import java.sql.Connection
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

/**
 * Execute the given transaction.
 *
 * @receiver the current [ApplicationCall]
 * @param key the database to use (configured by [DatabasePluginConfigurator.addDatabase])
 * @param isolation the transaction isolation to use (see [Connection])
 * @param block the transaction
 * @return the result
 */
suspend fun <T> ApplicationCall.transaction(key: String?, isolation: Int? = null, block: suspend Transaction.() -> T): T {
	val config = this.application.attributes[databasePluginConfigurationKey]
	return newSuspendedTransaction(db = config[key], transactionIsolation = isolation, statement = block)
}

/**
 * Execute the given transaction.
 *
 * @receiver the current [ApplicationCall]
 * @param isolation the transaction isolation to use (see [Connection])
 * @param block the transaction
 * @return the result
 */
suspend fun <T> ApplicationCall.transaction(isolation: Int? = null, block: suspend Transaction.() -> T): T {
	val config = this.application.attributes[databasePluginConfigurationKey]
	return transaction(config.defaultDatabaseKey, isolation, block)
}

/**
 * Execute the given transaction.
 *
 * @receiver the current [ApplicationCall]
 * @param key the database to use (configured by [DatabasePluginConfigurator.addDatabase])
 * @param isolation the transaction isolation to use (see [Connection])
 * @param block the transaction
 * @return the result
 */
suspend inline fun <T, reified E : Enum<E>> ApplicationCall.transaction(key: E, isolation: Int? = null, noinline block: suspend Transaction.() -> T): T {
	return transaction(key.toDatabaseKey(), isolation, block)
}
