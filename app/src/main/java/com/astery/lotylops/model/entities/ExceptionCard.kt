package com.astery.lotylops.model.entities

import androidx.room.Entity
import androidx.room.Index

@Entity(indices = [Index(value = ["repetitionDate"])])
class ExceptionCard(id: String, course: String, repeatLevel: Int, practiceLevel: Int,
                    repetitionDate: Int, mem: String?, isStudy:Boolean=false,
                    val question:String, val answer:String
): Card(
    id, course, repeatLevel,
    practiceLevel,
    repetitionDate, mem, isStudy



) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ExceptionCard) return false
        if (!super.equals(other)) return false

        if (question != other.question) return false
        if (answer != other.answer) return false

        return true
    }
}