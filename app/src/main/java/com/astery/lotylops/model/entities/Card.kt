package com.astery.lotylops.model.entities

import androidx.room.PrimaryKey

/** basic */
open class Card(
    @field:PrimaryKey var id: String, val course:String,
    var repeatLevel: Int, var practiceLevel: Int,
    var repetitionDate: Int, var mem: String?,
    var isStudy: Boolean = false

) {
    override fun toString(): String {
        return "Card(id='$id', course='$course', repeatLevel=$repeatLevel, practiceLevel=$practiceLevel, repetitionDate=$repetitionDate, mem=$mem)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Card) return false

        if (id != other.id) return false
        if (course != other.course) return false
        if (repeatLevel != other.repeatLevel) return false
        if (practiceLevel != other.practiceLevel) return false
        if (repetitionDate != other.repetitionDate) return false
        if (mem != other.mem) return false
        if (isStudy != other.isStudy) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + course.hashCode()
        result = 31 * result + repeatLevel
        result = 31 * result + practiceLevel
        result = 31 * result + repetitionDate
        result = 31 * result + (mem?.hashCode() ?: 0)
        result = 31 * result + isStudy.hashCode()
        return result
    }


}