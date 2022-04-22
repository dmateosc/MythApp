package dmateos.com.mythapp.infrastructure.plugins

import dmateos.com.mythapp.infrastructure.controller.mythController
import io.ktor.server.routing.*

import io.ktor.server.application.*
import io.ktor.server.response.*


fun Application.configureRouting() {
    val port = environment.config.propertyOrNull("ktor.deployment.port")?.getString() ?: "8080"
    val host = environment.config.propertyOrNull("ktor.deployment.host")?.getString() ?: "localhost"
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        mythController()
    }
}
