package com.example.gkeep
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gkeep.data.database.NotesDatabase
import com.example.gkeep.data.database.databaseInstance
import com.example.gkeep.data.tables.Notes
import kotlinx.coroutines.launch

class notesViewModel(val context: Context) : ViewModel(){

    var db: NotesDatabase
    init {
        db = databaseInstance.getDB(context)
    }

    fun upsertNote(notes: Notes){
        viewModelScope.launch {db.dao().upsertNote(notes)}
    }

    fun deleteNote(notes: Notes){
        viewModelScope.launch {db.dao().deleteNote(notes)}
    }

    fun getNotes() = db.dao().getNotes()

}