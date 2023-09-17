package de.talemke.database

/**
 * Converts the given enum-value to a unique string.
 *
 * **Note:** Can produce duplicates if `E` is a local class or of an anonymous object.
 */
@PublishedApi
internal inline fun <reified E : Enum<E>> E.toDatabaseKey(): String
	= (E::class.qualifiedName ?: "") + "/" + this.name
