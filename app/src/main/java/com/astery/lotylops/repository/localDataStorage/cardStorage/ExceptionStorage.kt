package com.astery.lotylops.repository.localDataStorage.cardStorage

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.ExceptionCard

open class ExceptionStorage:CardStorage(){
    override suspend fun getCardsForToday(today: Int): List<Card> {
        return cardDao.getExceptionCardsForToday(today)
    }

    override suspend fun getCardsForCourse(courseId: String): List<Card> {
        return cardDao.getExceptionCardsForCourse(courseId)
    }

    override suspend fun getCard(id: String): Card {
        return cardDao.getExceptionCard(id)
    }

    override suspend fun deleteCard(id: String) {
        cardDao.deleteExceptionCard(id)
    }

    override suspend fun deleteCards() {
        cardDao.deleteExceptionCards()
    }

    override suspend fun addCard(card: Card) {
        cardDao.addCard(card as ExceptionCard)
    }

    override suspend fun updateCard(card: Card) {
        cardDao.updateCard(card as ExceptionCard)
    }
}