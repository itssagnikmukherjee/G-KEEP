package com.example.gkeep.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.gkeep.data.tables.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface notesDao {

    @Upsert
    suspend fun upsertNote(notes: Notes)

    @Delete
    suspend fun deleteNote(notes: Notes)

    @Query("SELECT * FROM notes ORDER BY dateTime DESC")
    fun getNotes(): Flow<List<Notes>>

}
