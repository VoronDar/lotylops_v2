package com.astery.lotylops

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.astery.lotylops.repository.localDataStorage.dao.SentenceDao
import com.astery.lotylops.repository.localDataStorage.database.AppDatabase
import com.astery.lotylops.roomSentenceHelpers.SentenceHelper
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
class RoomSentenceTest {

    private lateinit var db: AppDatabase
    private lateinit var sentenceDao: SentenceDao

    @Before
    @Throws(Exception::class)
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDatabase::class.java
        )
            .build()
        sentenceDao = db.getSentenceDao()
    }


    /**
     * delete all cards and close db
     * */
    @After
    fun closeDb(){
        runBlocking {
            launch {
                db.close()
            }
        }
    }


    /**
     * check getExampleWithLinked()
     * add X sentences. Several of them with linked id. Check actual and required size
     * */
    @Test
    fun checkGetLinkedExample(){
        runBlocking{
            launch{

                sentenceDao.deleteExamples()

                val linkedId = "linked"
                val requiredSize = 2
                sentenceDao.addExample(SentenceHelper.getExample(12, linkedId))
                sentenceDao.addExample(SentenceHelper.getExample(15, linkedId))
                sentenceDao.addExample(SentenceHelper.getExample(16, "not"))

                val examples = sentenceDao.getExamples(linkedId)
                assertTrue("got invalid size of examples with linked id. got ${examples.size}, required - $requiredSize", examples.size == requiredSize)

                sentenceDao.deleteExamples()

            }
        }
    }

    /**
     * check getTrainsWithLinked()
     * add X sentences. Several of them with linked id. Check actual and required size
     * */
    @Test
    fun checkGetLinkedTrains(){
        runBlocking{
            launch{

                sentenceDao.deleteTrains()

                val linkedId = "linked"
                val requiredSize = 2
                sentenceDao.addTrain(SentenceHelper.getTrain(12, linkedId))
                sentenceDao.addTrain(SentenceHelper.getTrain(15, linkedId))
                sentenceDao.addTrain(SentenceHelper.getTrain(16, "not"))

                val examples = sentenceDao.getTrains(linkedId)
                assertTrue("got invalid size of trains with linked id. got ${examples.size}, required - $requiredSize", examples.size == requiredSize)

                sentenceDao.deleteTrains()

            }
        }
    }

    /**
     * check getSelectTrainsWithLinked()
     * add X sentences. Several of them with linked id. Check actual and required size
     * */
    @Test
    fun checkGetLinkedSelectTrain(){
        runBlocking{
            launch{

                sentenceDao.deleteSelectTrains()

                val linkedId = "linked"
                val requiredSize = 2
                sentenceDao.addSelectTrain(SentenceHelper.getSelectTrain(12, linkedId))
                sentenceDao.addSelectTrain(SentenceHelper.getSelectTrain(15, linkedId))
                sentenceDao.addSelectTrain(SentenceHelper.getSelectTrain(16, "not"))

                val examples = sentenceDao.getSelectTrains(linkedId)
                assertTrue("got invalid size of select train with linked id. got ${examples.size}, required - $requiredSize", examples.size == requiredSize)

                sentenceDao.deleteSelectTrains()

            }
        }
    }


}