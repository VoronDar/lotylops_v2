package com.astery.lotylops

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.astery.lotylops.model.appValues.Branch
import com.astery.lotylops.repository.localDataStorage.cardStorage.CardStorage
import com.astery.lotylops.repository.localDataStorage.dao.CardDao
import com.astery.lotylops.repository.localDataStorage.dao.CourseDao
import com.astery.lotylops.repository.localDataStorage.database.AppDatabase
import com.astery.lotylops.roomCardsHelpers.CardStorageTest
import com.astery.lotylops.roomCardsHelpers.CardStorageTestFactory
import com.astery.lotylops.roomCourseHelpers.CourseHelper
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
class RoomCardsWithCoursesTest {

    private lateinit var db: AppDatabase
    private lateinit var cardDao:CardDao
    private lateinit var courseDao: CourseDao

    @Before
    @Throws(Exception::class)
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDatabase::class.java
        )
            .build()
        cardDao = db.getCardDao()
        courseDao = db.getCourseDao()
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
     * check cardStorage.getCardsForToday()
     * add X cards with different repetitionDate. Get cards for today. Compare size with required
     * */
    @Test
    fun checkAllCardsForCourse(){
        runTest(object:CardTestRunnable{
            override suspend fun run(dao: CardStorage, branch: Branch) {

                dao.deleteCards()
                courseDao.deleteCourses()

                val courseId = "courseId"

                val course = CourseHelper.getCourse(courseId, branch)
                courseDao.addCourse(course)

                val count = 5

                val card = (dao as CardStorageTest).getCardForCourse("id", courseId)
                for (i in 1..count) {
                    card.id = "%$i"
                    dao.addCard(card)
                }

                val gotCourse = courseDao.getCourse(courseId)
                assertTrue("got invalid course", course == gotCourse)

                val gotCards = dao.getCardsForCourse(gotCourse.id)
                assertTrue("got invalid amount of cards for course. Got ${gotCards.size}, " +
                        "required $count", gotCards.size == count)

                dao.deleteCards()
                courseDao.deleteCourses()

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
        suspend fun run(dao:CardStorage, branch: Branch)
    }

}