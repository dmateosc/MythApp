package dmateos.com.mythapp.creature.application.create

import dmateos.com.mythapp.creature.application.create.model.CreateCreature
import dmateos.com.mythapp.creature.domain.model.Creature
import dmateos.com.mythapp.creature.infrastructure.persistence.PostgresSQLCreatureRepository

class CreatureCreator(val repository: PostgresSQLCreatureRepository) {

    suspend fun save(creature: CreateCreature){
        repository.save(CreateCreature.toDomain(creature))
    }

}