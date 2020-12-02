package com.fernandodominguezpacheco.reign.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Refresh(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val date_refresh : Date
)