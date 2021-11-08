package com.astery.lotylops.roomCardsHelpers

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.GrammarCard
import com.astery.lotylops.repository.localDataStorage.cardStorage.GrammarStorage

class GrammarStorageTest:GrammarStorage(), CardStorageTest {
    override fun getCardForInsert(id:String): Card {
        return GrammarCard(id, "course", 1, 1,1,
            "asdasd", false, "theory", "12")
    }

    override fun getCardForUpdate(id:String): Card {
        return GrammarCard(id, "smt", 2, 3,4,
            null, true, "wrd", "null")
    }
}