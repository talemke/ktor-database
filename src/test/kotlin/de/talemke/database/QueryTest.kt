package de.talemke.database

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.testing.*
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import kotlin.test.Test
import kotlin.test.assertEquals

class QueryTest {

	@Test
	fun testQuery() = testApplication {
		application {
			install(Database) {
				addDatabase(createDatabase())
			}
			routing {
				get("/") {
					val result = call.transaction {
						Table.Dual.selectAll().execute(this)
					}
					call.respondText(result.toString(), status = HttpStatusCode.OK)
				}
			}
		}

		val client = createClient {
		}
		val response = client.get("/")
		assertEquals(HttpStatusCode.OK, response.status)
		println(response.bodyAsText())
	}

}
