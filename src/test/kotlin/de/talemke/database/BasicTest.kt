package de.talemke.database

import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlin.test.Test

class BasicTest {

	@Test
	fun testInstall() = testApplication {
		application {
			install(Database)
		}
	}

}
