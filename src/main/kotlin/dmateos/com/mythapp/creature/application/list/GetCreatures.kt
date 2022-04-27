package dmateos.com.mythapp.creature.application.list

import dmateos.com.mythapp.creature.domain.model.Creature
import dmateos.com.mythapp.creature.domain.repository.CreatureRepository

class GetCreatures(private val repository: CreatureRepository) {

    suspend fun getAll(): List<Creature>{
        return repository.getAll()
    }


}