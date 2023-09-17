package de.talemke.database

import kotlin.test.Test
import kotlin.test.assertFailsWith

class TestErrors {

	@Test
	fun testDuplicateDatabase() {
		val configurator = DatabasePluginConfigurator()
		configurator.addDatabase(createDatabase())
		assertFailsWith<IllegalStateException> {
			configurator.addDatabase(createDatabase())
		}
	}

}
