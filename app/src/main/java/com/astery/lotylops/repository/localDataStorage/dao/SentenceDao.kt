package com.astery.lotylops.repository.localDataStorage.dao

import androidx.room.*
import com.astery.lotylops.model.entities.SelectTrain
import com.astery.lotylops.model.entities.Sentence
import com.astery.lotylops.model.entities.TrainSpec

@Dao
interface SentenceDao {
    @Query("SELECT * FROM EXAMPLE WHERE linked_id == :id")
    suspend fun getExamples(id:String):List<Sentence.Example>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExample(example: Sentence.Example)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateExample(example: Sentence.Example)

    @Query("DELETE FROM EXAMPLE WHERE linked_id = :linkedId")
    fun deleteExampleWithLinkedId(linkedId: String)

    @Query("DELETE FROM EXAMPLE WHERE id = :id")
    fun deleteExample(id: Long)

    @Query("DELETE FROM EXAMPLE")
    fun deleteExamples()


    @Query("SELECT * FROM TRAIN WHERE linked_id == :id")
    suspend fun getTrains(id:String):List<Sentence.Train>
    @Query("SELECT * FROM TRAIN WHERE linked_id == :id AND specialization == :specialization")
    suspend fun getTrains(id:Int, specialization: TrainSpec):List<Sentence.Train>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrain(example: Sentence.Train)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTrain(train: Sentence.Train)

    @Query("DELETE FROM TRAIN WHERE linked_id = :linkedId")
    fun deleteTrainWithLinkedId(linkedId: String)

    @Query("DELETE FROM TRAIN WHERE id = :id")
    fun deleteTrain(id: Long)

    @Query("DELETE FROM TRAIN")
    fun deleteTrains()



    @Query("SELECT * FROM SelectTrain WHERE cardId == :id")
    suspend fun getSelectTrains(id:String):List<SelectTrain>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSelectTrain(example: SelectTrain)

    @Query("DELETE FROM SELECTTRAIN WHERE id = :id")
    fun deleteSelectTrain(id: Long)

    @Query("DELETE FROM SELECTTRAIN")
    fun deleteSelectTrains()

}