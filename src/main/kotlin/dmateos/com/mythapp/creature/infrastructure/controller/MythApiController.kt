package dmateos.com.mythapp.creature.infrastructure.controller

import dmateos.com.mythapp.creature.application.list.GetCreatures
import dmateos.com.mythapp.creature.infrastructure.controller.model.CreatureResponse
import dmateos.com.mythapp.creature.infrastructure.persistence.PostgresSQLCreatureRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.mythController() {

    route("/mythapp") {
        get {
            call.respond(
                HttpStatusCode.OK, GetCreatures(PostgresSQLCreatureRepository()).getAll()
            )
        }
        get("{id?}") {

        }
        get("{religion}") {

        }
    }

}