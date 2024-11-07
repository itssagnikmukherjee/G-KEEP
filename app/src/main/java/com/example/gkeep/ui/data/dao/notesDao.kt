package com.example.gkeep.ui.data.dao

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.gkeep.ui.data.tables.Notes

interface notesDao {

    @Upsert
    fun upsertNote(notes: Notes)

    @Delete
    fun deleteNote(notes: Notes)

    @Query("SELECT * FROM notes ORDER BY dateTime DESC")
    fun getNotes(): List<Notes>

}
