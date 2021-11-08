package com.astery.lotylops.model.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.TypeConverters
import com.astery.lotylops.model.entities.converters.ListToStringConverter

@Entity(indices = [Index(value = ["repetitionDate"])])
@TypeConverters(ListToStringConverter::class)
class PhoneticsCard(id: String, course: String, repeatLevel: Int, practiceLevel: Int,
                    repetitionDate: Int, mem: String?, isStudy:Boolean=false,
                    val theory:String, val transcription:String,
                    val  wordExamples:List<String>?, val wordTrains:List<String>?
): Card(
    id, course, repeatLevel,
    practiceLevel,
    repetitionDate, mem, isStudy
){

    @Ignore var selectTrains:List<SelectTrain>? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhoneticsCard) return false
        if (!super.equals(other)) return false

        if (theory != other.theory) return false
        if (transcription != other.transcription) return false
        if (wordExamples != other.wordExamples) return false
        if (wordTrains != other.wordTrains) return false
        if (selectTrains != other.selectTrains) return false

        return true
    }

}