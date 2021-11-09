package com.astery.lotylops

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.astery.lotylops.model.appValues.Branch
import com.astery.lotylops.repository.localDataStorage.dao.CourseDao
import com.astery.lotylops.repository.localDataStorage.database.AppDatabase
import com.astery.lotylops.roomCardsHelpers.CardStorageTest
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
class RoomCoursesTest {

    private lateinit var db: AppDatabase
    private lateinit var courseDao: CourseDao

    @Before
    @Throws(Exception::class)
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDatabase::class.java
        )
            .build()
        courseDao = db.getCourseDao()
    }


    /**
     * delete all cards and close db
     * */
    @After
    fun closeDb(){
        runBlocking {
            launch {
                courseDao.deleteCourses()
                db.close()
            }
        }
    }

    /**
     * check deleteCards()
     * add some values to table and delete them all. If there are some values left - alert
     * */
    @Test
    fun checkDeleteAll(){
        runBlocking {
            launch{

                val branch = Branch.Vocabulary

                for (i in 1..10){
                    courseDao.addCourse(CourseHelper.getCourse("$i", branch))
                }
                courseDao.deleteCourses()

                val gotCards = courseDao.getAllCourses(branch)

                assertTrue("table is not empty after delete, actual size = ${gotCards.size}",
                    gotCards.isEmpty()
                )
            }
        }
    }

    @Test
    fun checkDelete(){
        runTest(object: CourseTestRunnable {
            override suspend fun run(branch: Branch) {
                courseDao.deleteCourses()

                val maxSize = 10
                for (i in 1..maxSize){
                    val id = "$i"
                    courseDao.addCourse((CourseHelper.getCourse(id, branch)))
                }
                courseDao.deleteCourse("4")
                assertTrue("failed to delete a course from ${branch.name}",
                    courseDao.getAllCourses(branch)
                        .size == (maxSize-1))

                courseDao.deleteCourses()
            }
        })
    }


    /** func that run test for all branches */
    private fun runTest(runnable: CourseTestRunnable) {
        runBlocking {
            launch {
                for (i in Branch.values()) {
                    runnable.run(i)
                }
            }
        }
    }


    /** run should be used to write a test itself */
    interface CourseTestRunnable{
        suspend fun run(branch: Branch)
    }

}