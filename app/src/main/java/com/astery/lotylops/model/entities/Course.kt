package com.astery.lotylops.model.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.astery.lotylops.model.appValues.Branch

@Entity
data class Course(
    @PrimaryKey(autoGenerate = false) val id:String,
    val name:String, val difficulty:Int,
    val version:Int, val accessibility:Boolean=true,
    var hasAccess:Boolean=true, var isEnabled:Boolean=false,
    val branch: Branch
){
    @Ignore var cards: List<Card>? = null
}