package dmateos.com.mythapp.creature.domain.model

import dmateos.com.mythapp.creature.domain.model.enums.ReligionEnum

data class Creature(
    val creatureId: CreatureId,
    val creatureName: CreatureName,
    val description: Description,
    val type: Type,
    val religion: Religion,
    val abilities: Abilities
)

data class Description (val value: String)

class CreatureName  (val value: String)

class CreatureId  (val value: String)

data class Religion (var religionEnum: ReligionEnum)


data class Abilities (val abilities: String)


