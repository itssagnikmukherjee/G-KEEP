package com.example.gkeep.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gkeep.data.dao.notesDao
import com.example.gkeep.data.tables.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase(){
    abstract fun dao(): notesDao
}