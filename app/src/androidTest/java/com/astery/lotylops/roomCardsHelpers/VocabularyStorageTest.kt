package com.astery.lotylops.roomCardsHelpers

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.VocabularyCard
import com.astery.lotylops.repository.localDataStorage.cardStorage.VocabularyStorage

class VocabularyStorageTest:VocabularyStorage(), CardStorageTest {
    override fun getCardForInsert(id:String): Card {
        return VocabularyCard(id, "course", 1, 1,1,
            "asdasd", false, "word", null, null, "translate",
            "sadasd", null, null, null, -1, -1)
    }

    override fun getCardForUpdate(id:String): Card {
        return VocabularyCard(id, "smt", 2, 3,4,
            null, true, "wrd", "null", "null", null,
            null, "asd", "asdsad", "asdasdas", 2, 3)
    }
}