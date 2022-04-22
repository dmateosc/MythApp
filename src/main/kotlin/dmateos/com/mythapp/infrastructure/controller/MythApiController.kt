package dmateos.com.mythapp.infrastructure.controller

import dmateos.com.mythapp.infrastructure.controller.model.CreatureResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.mythController() {

    route("/mythapp") {
        get {
            call.respond(
                HttpStatusCode.OK, listOf(
                    CreatureResponse(
                        "1",
                        "1",
                        "1",
                        "",
                        "",
                        ""
                    )
                )
            )
        }
        get("{id?}") {

        }
        get("{religion}") {

        }
    }

}