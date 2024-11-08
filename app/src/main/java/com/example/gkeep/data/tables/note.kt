package com.example.gkeep.data.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity
data class Notes(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val noteTxt : String,
    val title : String,
    val dateTime : String,
    )