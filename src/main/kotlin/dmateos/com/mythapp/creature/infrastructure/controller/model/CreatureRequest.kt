package dmateos.com.mythapp.creature.infrastructure.controller.model

import dmateos.com.mythapp.creature.domain.model.enums.ReligionEnum
import dmateos.com.mythapp.creature.domain.model.enums.TypeEnum

data class CreatureRequest(
    val creatureName: String,
    val description: String,
    val type: TypeEnum,
    val religion: ReligionEnum,
    val abilities: List<String>
)