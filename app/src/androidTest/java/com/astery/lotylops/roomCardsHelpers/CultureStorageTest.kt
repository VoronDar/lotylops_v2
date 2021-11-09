package com.astery.lotylops.roomCardsHelpers

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.CultureCard
import com.astery.lotylops.repository.localDataStorage.cardStorage.CultureStorage

class CultureStorageTest: CultureStorage(), CardStorageTest {
    override fun getCardForInsert(id:String): Card {
        return CultureCard(id, "course", 1, 1,1,
            "asdasd", false, "theory")
    }

    override fun getCardForUpdate(id:String): Card {
        return CultureCard(id, "smt", 2, 3,4,
            null, true, "wrd")
    }

    override fun getCardForCourse(id: String, courseId: String): Card {
        return CultureCard(id, courseId, 2, 3,4,
            null, true, "wrd")
    }
}