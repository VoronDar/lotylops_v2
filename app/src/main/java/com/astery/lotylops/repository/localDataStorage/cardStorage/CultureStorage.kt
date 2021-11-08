package com.astery.lotylops.repository.localDataStorage.cardStorage

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.CultureCard

open class CultureStorage:CardStorage(){
    override suspend fun getCardsForToday(today: Int): List<Card> {
        return cardDao.getCultureCardsForToday(today)
    }

    override suspend fun getCardsForCourse(courseId: String): List<Card> {
        return cardDao.getCultureCardsForCourse(courseId)
    }

    override suspend fun getCard(id: String): Card {
        return cardDao.getCultureCard(id)
    }

    override suspend fun deleteCard(id: String) {
        cardDao.deleteCultureCard(id)
    }

    override suspend fun deleteCards() {
        cardDao.deleteCultureCards()
    }

    override suspend fun addCard(card: Card) {
        cardDao.addCard(card as CultureCard)
    }

    override suspend fun updateCard(card: Card) {
        cardDao.updateCard(card as CultureCard)
    }
}