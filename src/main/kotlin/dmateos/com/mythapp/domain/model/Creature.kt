package dmateos.com.mythapp.domain.model

import dmateos.com.mythapp.domain.model.enums.ReligionEnum

data class Creature(
                    val id: CreatureId,
                    val name: Name,
                    val description: Description,
                    val type: Type,
                    val religion: Religion,
                    val abilities: Abilities
)

data class Description (val value: String)

class Name  (val value: String)

class CreatureId  (val value: String)

data class Religion (var religionEnum: ReligionEnum)


data class Abilities (val valueList: List<String>)


