package dmateos.com.mythapp.creature.infrastructure.persistence

import dmateos.com.mythapp.creature.domain.model.*
import dmateos.com.mythapp.creature.domain.model.enums.ReligionEnum
import dmateos.com.mythapp.creature.domain.model.enums.TypeEnum
import dmateos.com.mythapp.creature.domain.repository.CreatureRepository
import dmateos.com.mythapp.creature.infrastructure.persistence.entity.CreatureDB
import dmateos.com.mythapp.creature.infrastructure.persistence.entity.CreaturesDB
import dmateos.com.mythapp.shared.infrastructure.config.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class PostgresSQLCreatureRepository: CreatureRepository {

    private fun resultRowToCreature(row: ResultRow) = Creature(
        creatureId = CreatureId(row[CreaturesDB.creatureId]),
        creatureName = CreatureName(row[CreaturesDB.creatureName]),
        description = Description(row[CreaturesDB.description]),
        type = Type(TypeEnum.valueOf(row[CreaturesDB.type])),
        religion = Religion(ReligionEnum.valueOf(row[CreaturesDB.religion])),
        abilities = Abilities(listOf(row[CreaturesDB.abilities]))
    )

    override suspend fun getAll(): List<Creature> =
        dbQuery {
            CreaturesDB.selectAll().map(::resultRowToCreature)
        }
}