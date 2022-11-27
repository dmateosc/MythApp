package dmateos.com.mythapp.creature.application.list.model

import dmateos.com.mythapp.creature.domain.model.Creature

data class GetCreature(
    val creatureId: String,
    val creatureName: String,
    val description: String,
    val type: String,
    val religion: String,
    val abilities: List<String>
) {
    companion object {
        fun fromDomain(creature: Creature): GetCreature {
            return GetCreature(
                creatureId = creature.creatureId.value,
                creatureName = creature.creatureName.value,
                description = creature.description.value,
                religion = creature.religion.religionEnum.name,
                type = creature.type.typeEnum.name,
                abilities = creature.abilities.abilities.split(",").map { it.trim() }
            )
        }
    }
}
