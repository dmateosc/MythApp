package dmateos.com.mythapp.creature.application.create.model

import dmateos.com.mythapp.creature.application.create.CreatureCreator
import dmateos.com.mythapp.creature.domain.model.*
import dmateos.com.mythapp.creature.domain.model.enums.ReligionEnum
import dmateos.com.mythapp.creature.domain.model.enums.TypeEnum
import java.util.UUID

data class CreateCreature(
    val creatureName: String,
    val description: String,
    val type: String,
    val religion: String,
    val abilities: List<String>


) {
    companion object {
        fun toDomain(createCreature: CreateCreature): Creature {
            return Creature(
                creatureId = CreatureId(UUID.randomUUID().toString()),
                creatureName = CreatureName(createCreature.creatureName),
                description = Description(createCreature.description),
                type = Type(TypeEnum.valueOf(createCreature.type)),
                religion = Religion(ReligionEnum.valueOf(createCreature.religion)),
                abilities = Abilities(createCreature.abilities.joinToString())

            )
        }
    }
}