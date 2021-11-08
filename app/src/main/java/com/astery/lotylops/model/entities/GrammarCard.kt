package com.astery.lotylops.model.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index


@Entity(indices = [Index(value = ["repetitionDate"])])
class GrammarCard(id: String, course: String, repeatLevel: Int, practiceLevel: Int,
                  repetitionDate: Int, mem: String?, isStudy:Boolean = false,
                  val theory:String,
                  val mistakeId:String
): Card(
    id, course, repeatLevel,
    practiceLevel,
    repetitionDate, mem, isStudy
){
    @Ignore var selectTrain:List<SelectTrain>? = null
    @Ignore var blockTrain:List<Sentence.Train>? = null
    @Ignore var writeTrain:List<Sentence.Train>? = null


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GrammarCard) return false
        if (!super.equals(other)) return false

        if (theory != other.theory) return false
        if (mistakeId != other.mistakeId) return false
        if (selectTrain != other.selectTrain) return false
        if (blockTrain != other.blockTrain) return false
        if (writeTrain != other.writeTrain) return false

        return true
    }


}
