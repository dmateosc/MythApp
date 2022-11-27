package dmateos.com.mythapp.creature.infrastructure.persistence

import dmateos.com.mythapp.creature.domain.model.*
import dmateos.com.mythapp.creature.domain.model.enums.ReligionEnum
import dmateos.com.mythapp.creature.domain.model.enums.TypeEnum
import dmateos.com.mythapp.creature.domain.repository.CreatureRepository
import dmateos.com.mythapp.creature.infrastructure.persistence.entity.Creatures
import dmateos.com.mythapp.shared.infrastructure.config.create
import dmateos.com.mythapp.shared.infrastructure.config.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class PostgresSQLCreatureRepository: CreatureRepository {

    init {
        create(Creatures)
    }
    private fun resultRowToCreature(row: ResultRow) = Creature(
        creatureId = CreatureId(row[Creatures.creatureId]),
        creatureName = CreatureName(row[Creatures.creatureName]),
        description = Description(row[Creatures.description]),
        type = Type(TypeEnum.valueOf(row[Creatures.type])),
        religion = Religion(ReligionEnum.valueOf(row[Creatures.religion])),
        abilities = Abilities(row[Creatures.abilities])
    )

    override suspend fun getAll(): List<Creature> =
        dbQuery {
            Creatures.selectAll().map(::resultRowToCreature)
        }

    override suspend fun save(creature: Creature) {
        dbQuery {
            Creatures.insert {
                it[creatureId] = creature.creatureId.value
                it[creatureName] = creature.creatureName.value
                it[description] = creature.description.value
                it[type] = creature.type.typeEnum.name
                it[religion] = creature.religion.religionEnum.name
                it[abilities] = creature.abilities.abilities
            }
        }
    }

}