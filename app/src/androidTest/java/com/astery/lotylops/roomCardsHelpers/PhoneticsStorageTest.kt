package com.astery.lotylops.roomCardsHelpers

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.PhoneticsCard
import com.astery.lotylops.repository.localDataStorage.cardStorage.PhoneticsStorage

class PhoneticsStorageTest: PhoneticsStorage(), CardStorageTest {
    override fun getCardForInsert(id:String): Card {
        return PhoneticsCard(id, "course", 1, 1,1,
            "asdasd", false, "theory", "12", listOf("wo", "as"), listOf("wo", "as"))
    }

    override fun getCardForUpdate(id:String): Card {
        return PhoneticsCard(id, "smt", 2, 3,4,
            null, true, "wrd", "null", null, null)
    }

    override fun getCardForCourse(id: String, courseId: String): Card {
        return PhoneticsCard(id, courseId, 2, 3,4,
            null, true, "wrd", "null", null, null)
    }
}