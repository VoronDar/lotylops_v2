package com.astery.lotylops.model.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["cardId"])])
data class SelectTrain(@PrimaryKey(autoGenerate = true) val id:Long, val answer:String,
                       val right:String, val second:String, val third:String?, val fourth:String?,
                        val cardId:String)
