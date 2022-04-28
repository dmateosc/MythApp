package dmateos.com.mythapp.creature.domain.repository

import dmateos.com.mythapp.creature.domain.model.Creature

interface CreatureRepository {

    suspend fun getAll(): List<Creature>
    suspend fun save(creature: Creature)

}