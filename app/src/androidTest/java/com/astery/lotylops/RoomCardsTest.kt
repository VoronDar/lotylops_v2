package com.astery.lotylops

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.astery.lotylops.model.Branch
import com.astery.lotylops.repository.localDataStorage.cardStorage.CardStorage
import com.astery.lotylops.repository.localDataStorage.dao.CardDao
import com.astery.lotylops.repository.localDataStorage.database.AppDatabase
import com.astery.lotylops.roomCardsHelpers.CardStorageTest
import com.astery.lotylops.roomCardsHelpers.CardStorageTestFactory
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * check only CardDao (cardStorage) for every branch
 */
@RunWith(AndroidJUnit4::class)
class RoomCardsTest {

    private lateinit var db: AppDatabase
    private lateinit var cardDao:CardDao

    @Before
    @Throws(Exception::class)
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDatabase::class.java
        )
            .build()
        cardDao = db.getCardDao()
    }


    /**
     * delete all cards and close db
     * */
    @After
    fun closeDb(){
        runBlocking {
            launch {
                for (i in Branch.values()) {
                    val dao = CardStorageTestFactory.getCardStorage(i)
                    dao.cardDao = cardDao
                    dao.deleteCards()
                }
                db.close()
            }
        }
    }

    /**
     * check cardStorage.deleteCards()
     * add some values to table and delete them all. If there are some values left - alert
     * */
    @Test
    fun checkDeleteAll(){
        runTest( object:CardTestRunnable{
            override suspend fun run(dao: CardStorage, branch: Branch) {
                for (i in 1..10){
                    val id = "$i"
                    dao.addCard((dao as CardStorageTest).getCardForInsert(id))
                }
                dao.deleteCards()

                val gotCards = dao.getCardsForCourse((dao as CardStorageTest).getCardForInsert("id").course)

                assertTrue("table {$branch.name} is not empty after delete, actual size = ${gotCards.size}",
                    gotCards.isEmpty()
                )
            }
        })
    }

    /**
     * check cardStorage.deleteCard(id)
     * add some values to table and delete one of them. If the number of values doesn't change - alert
     * */
    @Test
    fun checkDelete(){
        runTest(object:CardTestRunnable{
            override suspend fun run(dao: CardStorage, branch: Branch) {
                dao.deleteCards()

                val maxSize = 10
                for (i in 1..maxSize){
                    val id = "$i"
                    dao.addCard((dao as CardStorageTest).getCardForInsert(id))
                }
                dao.deleteCard("4")
                assertTrue("failed to delete a card from ${branch.name}",
                    dao.getCardsForCourse((dao as CardStorageTest).getCardForInsert("id").course)
                        .size == (maxSize-1))

                dao.deleteCards()
            }
        })
    }


    /**
     * check cardStorage.getCardsForCourse()
     * add X cards to table for two courses. Compare X with getCardsFromCourse(courseID).size
     * */
    @Test
    fun checkCardsForCourse(){
        runTest( object:CardTestRunnable{
            override suspend fun run(dao: CardStorage, branch: Branch) {

                dao.deleteCards()

                val size = 5
                for (i in 1..size){
                    val id = "$i"
                    dao.addCard((dao as CardStorageTest).getCardForInsert(id))
                    dao.addCard((dao as CardStorageTest).getCardForUpdate("$id ud"))
                }
                assertTrue("got invalid number of card for course from {$branch.name}",
                    dao.getCardsForCourse((dao as CardStorageTest).getCardForInsert("id").course)
                        .size == size)

                assertTrue("got invalid number of card for course from {$branch.name}",
                    dao.getCardsForCourse((dao as CardStorageTest).getCardForUpdate("id").course)
                        .size == size)

                dao.deleteCards()
            }
        })
    }



    /**
     * check cardStorage.addCard(), cardStorage.updateCard(), cardStorage.getCard()
     * add a card, get it. check correctness. Repeat with update.
     * */
    @Test
    fun checkInsertAndUpdate(){
        runTest(object:CardTestRunnable{
            override suspend fun run(dao: CardStorage, branch: Branch) {
                val id = "id"

                dao.deleteCard(id)

                val card = (dao as CardStorageTest).getCardForInsert(id)
                val updateCard = (dao as CardStorageTest).getCardForUpdate(id)

                dao.addCard(card)
                assertTrue("insert checked ${branch.name}", dao.getCard(id) == card)

                dao.updateCard(updateCard)
                assertTrue("update checked ${branch.name}", dao.getCard(id) == updateCard)

                dao.deleteCard(id)
            }
        })
    }

    /**
     * check cardStorage.getCardsForToday()
     * add X cards with different repetitionDate. Get cards for today. Compare size with required
     * */
    @Test
    fun checkGetToday(){
        runTest(object:CardTestRunnable{
            override suspend fun run(dao: CardStorage, branch: Branch) {

                dao.deleteCards()

                val repetitionDate = 3

                val card = (dao as CardStorageTest).getCardForInsert("id")
                for (i in 1..5) {
                    card.id = "%$i"
                    card.repetitionDate = i
                    dao.addCard(card)
                }

                val cards = dao.getCardsForToday(repetitionDate)
                assertTrue("got invalid amount of cards for today. Got ${cards.size}, " +
                        "required $repetitionDate", cards.size == repetitionDate)

                dao.deleteCards()
            }
        })
    }


    /** func that run test for all branches */
    private fun runTest(runnable: CardTestRunnable) {
        runBlocking {
            launch {
                for (i in Branch.values()) {
                    val dao = CardStorageTestFactory.getCardStorage(i)
                    dao.cardDao = cardDao
                    runnable.run(dao, i)
                }
            }
        }
    }


    /** run should be used to write a test itself */
    interface CardTestRunnable{
        suspend fun run(dao:CardStorage, branch:Branch)
    }

}