package com.example.gkeep.ui.data.database

import android.content.Context
import androidx.room.Room

object databaseInstance {
    fun getDB(context: Context): NotesDatabase{
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            "notes_database"
        ).allowMainThreadQueries().build()
    }
}