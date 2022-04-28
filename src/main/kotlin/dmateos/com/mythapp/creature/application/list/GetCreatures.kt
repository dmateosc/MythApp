package dmateos.com.mythapp.creature.application.list

import dmateos.com.mythapp.creature.application.list.model.GetCreature
import dmateos.com.mythapp.creature.domain.model.Creature
import dmateos.com.mythapp.creature.domain.repository.CreatureRepository

class GetCreatures(private val repository: CreatureRepository) {

    suspend fun getAll(): List<GetCreature> {
        return repository.getAll().map { GetCreature.fromDomain(it) }
    }


}