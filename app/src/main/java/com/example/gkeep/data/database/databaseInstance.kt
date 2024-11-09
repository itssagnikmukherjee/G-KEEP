package com.example.gkeep.data.database

import android.content.Context
import androidx.room.Room
import com.example.gkeep.DB_NAME

object databaseInstance {
    fun getDB(context: Context): NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            name = DB_NAME
        ).build()
    }
}