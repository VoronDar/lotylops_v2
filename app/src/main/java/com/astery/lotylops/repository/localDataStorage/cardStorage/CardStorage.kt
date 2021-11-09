package com.astery.lotylops.repository.localDataStorage.cardStorage

import com.astery.lotylops.model.appValues.Branch
import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.repository.localDataStorage.dao.CardDao
import javax.inject.Inject

abstract class CardStorage {
    @Inject lateinit var cardDao: CardDao

    abstract suspend fun getCardsForToday(today:Int):List<Card>
    abstract suspend fun getCardsForCourse(courseId:String):List<Card>
    abstract suspend fun getCard(id:String): Card
    abstract suspend fun addCard(card: Card)
    abstract suspend fun updateCard(card: Card)
    abstract suspend fun deleteCard(id: String)
    abstract suspend fun deleteCards()

    companion object {
        fun getCardStorage(branch: Branch):CardStorage {
            return when(branch){
                Branch.Vocabulary -> VocabularyStorage()
                Branch.Phraseology -> PhraseologyStorage()
                Branch.Grammar -> GrammarStorage()
                Branch.Exceptions -> ExceptionStorage()
                Branch.Phonetics -> PhoneticsStorage()
                Branch.Culture -> CultureStorage()
            }
        }
    }
}
