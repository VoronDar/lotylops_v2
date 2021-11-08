package com.astery.lotylops.repository.localDataStorage.cardStorage

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.GrammarCard

open class GrammarStorage:CardStorage(){
    override suspend fun getCardsForToday(today: Int): List<Card> {
        return cardDao.getGrammarCardsForToday(today)
    }

    override suspend fun getCardsForCourse(courseId: String): List<Card> {
        return cardDao.getGrammarCardsForCourse(courseId)
    }

    override suspend fun getCard(id: String): Card {
        return cardDao.getGrammarCard(id)
    }

    override suspend fun deleteCard(id: String) {
        cardDao.deleteGrammarCard(id)
    }

    override suspend fun deleteCards() {
        cardDao.deleteGrammarCards()
    }

    override suspend fun addCard(card: Card) {
        cardDao.addCard(card as GrammarCard)
    }

    override suspend fun updateCard(card: Card) {
        cardDao.updateCard(card as GrammarCard)
    }
}