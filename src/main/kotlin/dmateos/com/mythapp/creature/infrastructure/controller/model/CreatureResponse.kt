package dmateos.com.mythapp.creature.infrastructure.controller.model

data class CreatureResponse (
    val id: String,
    val name: String,
    val description: String,
    val type: String,
    val religion: String,
    val abilities: String
)