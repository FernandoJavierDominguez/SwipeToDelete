package com.fernandodominguezpacheco.reign.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Story(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val story_title : String?,
    val author : String?,
    val story_url : String?,
    val created_at : Date
)