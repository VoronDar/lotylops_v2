package com.astery.lotylops.repository.localDataStorage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.astery.lotylops.model.appValues.Branch
import com.astery.lotylops.model.entities.*

@Dao
interface CourseDao {

    @Query("SELECT * FROM Course WHERE id == :id")
    suspend fun getCourse(id:String):Course

    @Query("SELECT * FROM Course WHERE branch == :branch")
    suspend fun getAllCourses(branch: Branch):List<Course>

    @Query("SELECT * FROM Course WHERE  branch == :branch AND difficulty == :difficulty")
    suspend fun getAllByDifficulty(branch: Branch, difficulty:Int):List<Course>

    @Insert(onConflict = REPLACE)
    suspend fun addCourse(course:Course)

    @Update(onConflict = REPLACE)
    suspend fun updateCourse(course:Course)

    @Query("DELETE FROM Course WHERE id = :id")
    fun deleteCourse(id: String)

    @Query("DELETE FROM Course")
    fun deleteCourses()
}