package com.astery.lotylops.roomCardsHelpers

import com.astery.lotylops.model.entities.Card

/**
 * decorator for cardStorage classes used for tests {@see RoomCardsTest}
 * return cards for two cases. These cards must be completely different (every field must be different)
 * */
interface CardStorageTest {
    fun getCardForInsert(id:String): Card
    fun getCardForUpdate(id:String): Card
}