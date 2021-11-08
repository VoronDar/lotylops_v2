package com.astery.lotylops.model.entities

import androidx.room.*

@Entity(indices = [Index(value = ["repetitionDate"])])
class CultureCard(id: String, course: String, repeatLevel: Int, practiceLevel: Int,
                  repetitionDate: Int, mem: String?, isStudy:Boolean = false,
                  val theory:String
): Card(
    id, course, repeatLevel,
    practiceLevel,
    repetitionDate, mem, isStudy
){
    @Ignore var selectTrains:List<SelectTrain>? = null


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CultureCard) return false
        if (!super.equals(other)) return false

        if (theory != other.theory) return false
        if (selectTrains != other.selectTrains) return false

        return true
    }
}
