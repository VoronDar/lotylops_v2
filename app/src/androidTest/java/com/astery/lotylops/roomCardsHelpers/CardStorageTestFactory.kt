package com.astery.lotylops.roomCardsHelpers

import com.astery.lotylops.model.appValues.Branch
import com.astery.lotylops.repository.localDataStorage.cardStorage.CardStorage

object CardStorageTestFactory {
    fun getCardStorage(branch: Branch): CardStorage {
        return when(branch){
            Branch.Vocabulary -> VocabularyStorageTest()
            Branch.Phraseology -> PhraseologyStorageTest()
            Branch.Grammar -> GrammarStorageTest()
            Branch.Exceptions -> ExceptionStorageTest()
            Branch.Phonetics -> PhoneticsStorageTest()
            Branch.Culture -> CultureStorageTest()
        }
    }
}