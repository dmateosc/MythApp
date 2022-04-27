package dmateos.com.mythapp.creature.infrastructure.persistence.entity

import dmateos.com.mythapp.creature.domain.model.*
import org.jetbrains.exposed.sql.Table

data class CreatureDB(val creatureId: String,
                      val creatureName: String,
                      val description: String,
                      val type: String,
                      val religion: String,
                      val abilities: String
)

object CreaturesDB: Table(){

    val creatureId = varchar("creatureId", 32)
    val creatureName = varchar("creatureName", 128)
    val description = text("description")
    val type = varchar("type", 10)
    val religion = varchar("religion", 10)
    val abilities = varchar("abilities", 250)

}