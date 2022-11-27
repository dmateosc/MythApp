package dmateos.com.mythapp.shared.infrastructure.config

import io.ktor.serialization.kotlinx.json.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}
