package dmateos.com.mythapp.domain.model

import dmateos.com.mythapp.creature.domain.model.*

import dmateos.com.mythapp.creature.domain.model.enums.ReligionEnum
import dmateos.com.mythapp.creature.domain.model.enums.TypeEnum
import kotlin.test.Test


class CreatureTest{

    @Test
    fun testTypeEnum(){


        val creature = Creature(
            CreatureId("1"),
            CreatureName("name"),
            Description("desc"),
            Type(TypeEnum.GOD),
            Religion(ReligionEnum.GREEK),
            Abilities(arrayListOf("hola"))
        )

        print(creature)

    }
}