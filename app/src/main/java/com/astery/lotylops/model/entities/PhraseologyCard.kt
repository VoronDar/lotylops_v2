package com.astery.lotylops.model.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index

@Entity(indices = [Index(value = ["repetitionDate"])])
class PhraseologyCard(id: String, course: String, repeatLevel: Int, practiceLevel: Int,
                      repetitionDate: Int, mem: String?, isStudy:Boolean = false,
                      val word:String, val meaning:String?, val meaningNative:String?, val translate:String?,
                      val transcription:String?, val synonym:String?, val antonym:String?, val help:String?,
                      val group:Int, val part:Int
): Card(
    id, course, repeatLevel,
    practiceLevel,
    repetitionDate, mem, isStudy
){
    @Ignore var trains :ArrayList<Sentence>? = null
    @Ignore var examples :ArrayList<Sentence>? = null
    override fun toString(): String {
        return super.toString() + "VocabularyCard(word='$word', meaning=$meaning, meaningNative=$meaningNative, translate=$translate, transcription=$transcription, synonym=$synonym, antonym=$antonym, help=$help, group=$group, part=$part, trains=$trains, examples=$examples)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhraseologyCard) return false
        if (!super.equals(other)) return false

        if (word != other.word) return false
        if (meaning != other.meaning) return false
        if (meaningNative != other.meaningNative) return false
        if (translate != other.translate) return false
        if (transcription != other.transcription) return false
        if (synonym != other.synonym) return false
        if (antonym != other.antonym) return false
        if (help != other.help) return false
        if (group != other.group) return false
        if (part != other.part) return false
        if (trains != other.trains) return false
        if (examples != other.examples) return false

        return true
    }

}