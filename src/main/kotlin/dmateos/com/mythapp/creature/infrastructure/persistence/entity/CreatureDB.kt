package dmateos.com.mythapp.creature.infrastructure.persistence.entity

import org.jetbrains.exposed.sql.Table


object Creatures: Table(){

    val creatureId = varchar("creatureId", 256)
    val creatureName = varchar("creatureName", 128)
    val description = text("description")
    val type = varchar("type", 10)
    val religion = varchar("religion", 10)
    val abilities = varchar("abilities", 250)


}