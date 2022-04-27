package dmateos.com

import dmateos.com.mythapp.shared.infrastructure.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSecurity()
        configureHTTP()
        configureSerialization()
        initDB()
    }.start(wait = true)
}



