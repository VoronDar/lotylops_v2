package com.astery.lotylops.roomCardsHelpers

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.PhraseologyCard
import com.astery.lotylops.repository.localDataStorage.cardStorage.PhraseologyStorage

class PhraseologyStorageTest:PhraseologyStorage(), CardStorageTest {
    override fun getCardForInsert(id:String): Card {
        return PhraseologyCard(id, "course", 1, 1,1,
            "asdasd", false, "word", null, null, "translate",
            "sadasd", null, null, null, -1, -1)
    }

    override fun getCardForUpdate(id:String): Card {
        return PhraseologyCard(id, "smt", 2, 3,4,
            null, true, "wrd", "null", "null", null,
            null, "asd", "asdsad", "asdasdas", 2, 3)
    }

    override fun getCardForCourse(id: String, courseId: String): Card {
        return PhraseologyCard(id, courseId, 2, 3,4,
            null, true, "wrd", "null", "null", null,
            null, "asd", "asdsad", "asdasdas", 2, 3)
    }
}