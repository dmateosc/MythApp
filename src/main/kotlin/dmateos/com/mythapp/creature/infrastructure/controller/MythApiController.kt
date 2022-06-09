package dmateos.com.mythapp.creature.infrastructure.controller

import dmateos.com.mythapp.creature.application.create.CreatureCreator
import dmateos.com.mythapp.creature.application.create.model.CreateCreature
import dmateos.com.mythapp.creature.application.list.GetCreatures
import dmateos.com.mythapp.creature.infrastructure.controller.model.CreatureRequest
import dmateos.com.mythapp.creature.infrastructure.persistence.PostgresSQLCreatureRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
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
        post("creature") {
            val request = call.receive<CreatureRequest>()
            CreatureCreator(PostgresSQLCreatureRepository()).save(CreateCreature(
                request.creatureName,
                request.description,
                request.type.name,
                request.religion.name,
                abilities = request.abilities.toString()
            ))
            call.respond(HttpStatusCode.Created)
        }
    }

}