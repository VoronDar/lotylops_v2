package com.astery.lotylops.roomCardsHelpers

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.ExceptionCard
import com.astery.lotylops.repository.localDataStorage.cardStorage.ExceptionStorage

class ExceptionStorageTest: ExceptionStorage(), CardStorageTest {
    override fun getCardForInsert(id:String): Card {
        return ExceptionCard(id, "course", 1, 1,1,
            "asdasd", false, "theory", "12")
    }

    override fun getCardForUpdate(id:String): Card {
        return ExceptionCard(id, "smt", 2, 3,4,
            null, true, "wrd", "null")
    }
}