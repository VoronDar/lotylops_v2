package com.astery.lotylops.repository.localDataStorage.cardStorage

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.PhraseologyCard

open class PhraseologyStorage:CardStorage(){
    override suspend fun getCardsForToday(today: Int): List<Card> {
        return cardDao.getPhraseologyCardsForToday(today)
    }

    override suspend fun getCardsForCourse(courseId: String): List<Card> {
        return cardDao.getPhraseologyCardsForCourse(courseId)
    }

    override suspend fun getCard(id: String): Card {
        return cardDao.getPhraseologyCard(id)
    }

    override suspend fun deleteCard(id: String) {
        cardDao.deletePhraseologyCard(id)
    }

    override suspend fun deleteCards() {
        cardDao.deletePhraseologyCards()
    }

    override suspend fun addCard(card: Card) {
        cardDao.addCard(card as PhraseologyCard)
    }

    override suspend fun updateCard(card: Card) {
        cardDao.addCard(card as PhraseologyCard)
    }
}