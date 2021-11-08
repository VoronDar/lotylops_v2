package com.astery.lotylops.repository.localDataStorage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.astery.lotylops.model.entities.SelectTrain
import com.astery.lotylops.model.entities.Sentence
import com.astery.lotylops.model.entities.TrainSpec

@Dao
interface SentenceDao {
    @Query("SELECT * FROM EXAMPLE WHERE linked_id == :id")
    suspend fun getExamples(id:Int):List<Sentence.Example>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExample(example: Sentence.Example)

    @Query("SELECT * FROM TRAIN WHERE linked_id == :id")
    suspend fun getTrains(id:Int):List<Sentence.Train>
    @Query("SELECT * FROM TRAIN WHERE linked_id == :id AND specialization == :specialization")
    suspend fun getTrains(id:Int, specialization: TrainSpec):List<Sentence.Train>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrain(example: Sentence.Train)

    @Query("SELECT * FROM SelectTrain WHERE cardId == :id")
    suspend fun getSelectTrains(id:Int):List<SelectTrain>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSelectTrain(example: SelectTrain)
}