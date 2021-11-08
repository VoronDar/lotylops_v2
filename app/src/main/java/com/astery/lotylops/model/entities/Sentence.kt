package com.astery.lotylops.model.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.astery.lotylops.model.entities.converters.TrainSpecConverter

/** vocabulary, phraseology, grammar cards may have examples and trains.
 * */
sealed class Sentence (@field:PrimaryKey(autoGenerate = true) val id:Long,
                        val sentence:String,
                        val translate:String,
                        val linked_id:String){
    @Entity(indices = [Index(value = ["linked_id"])])


    class Example(id:Long, sentence: String, translate: String, linked_id: String)
        : Sentence(id, sentence,
        translate,
        linked_id)
    @Entity(indices = [Index(value = ["linked_id"])])


    @TypeConverters(TrainSpecConverter::class)
    class Train(id: Long, sentence: String, translate: String, linked_id: String, val specialization: TrainSpec = TrainSpec.WRITE_TRAIN)
        : Sentence(id, sentence,
        translate,
        linked_id)
}

enum class TrainSpec{
    BLOCK_TRAIN,
    WRITE_TRAIN
}