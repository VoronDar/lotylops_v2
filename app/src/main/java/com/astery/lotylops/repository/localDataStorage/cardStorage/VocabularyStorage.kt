package com.astery.lotylops.repository.localDataStorage.cardStorage

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.VocabularyCard

open class VocabularyStorage:CardStorage(){
    override suspend fun getCardsForToday(today: Int): List<Card> {
        return cardDao.getVocabularyCardsForTodayForStudy(today)
    }

    override suspend fun getCardsForCourse(courseId: String): List<Card> {
        return cardDao.getVocabularyCardsForCourse(courseId)
    }

    override suspend fun getCard(id: String): Card {
        return cardDao.getVocabularyCard(id)
    }

    override suspend fun deleteCard(id: String) {
        cardDao.deleteVocabularyCard(id)
    }

    override suspend fun deleteCards() {
        cardDao.deleteVocabularyCards()
    }

    override suspend fun addCard(card: Card) {
        cardDao.addCard(card as VocabularyCard)
    }

    override suspend fun updateCard(card: Card) {
        cardDao.updateCard(card as VocabularyCard)
    }
}