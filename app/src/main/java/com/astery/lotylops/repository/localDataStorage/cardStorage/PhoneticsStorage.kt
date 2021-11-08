package com.astery.lotylops.repository.localDataStorage.cardStorage

import com.astery.lotylops.model.entities.Card
import com.astery.lotylops.model.entities.PhoneticsCard

open class PhoneticsStorage:CardStorage(){
    override suspend fun getCardsForToday(today: Int): List<Card> {
        return cardDao.getPhoneticsCardsForToday(today)
    }

    override suspend fun getCardsForCourse(courseId: String): List<Card> {
        return cardDao.getPhoneticsCardsForCourse(courseId)
    }

    override suspend fun getCard(id: String): Card {
        return cardDao.getPhoneticsCard(id)
    }

    override suspend fun deleteCard(id: String) {
        cardDao.deletePhoneticsCard(id)
    }

    override suspend fun deleteCards() {
        cardDao.deletePhoneticsCards()
    }

    override suspend fun addCard(card: Card) {
        cardDao.addCard(card as PhoneticsCard)
    }

    override suspend fun updateCard(card: Card) {
        cardDao.updateCard(card as PhoneticsCard)
    }
}