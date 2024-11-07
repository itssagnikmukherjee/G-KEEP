package com.example.gkeep.ui.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoGrid(){
    var todo = someFakeTodos()
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2), modifier = Modifier.padding(20.dp)) {
        items(10){
            TodoCards(todo.random())
        }
    }
}

@Composable
fun TodoCards(todo: Todo){
    Box(modifier = Modifier.fillMaxWidth().padding(10.dp),
        contentAlignment = Alignment.Center){

        Card(onClick = {}) {
            Box(
                modifier = Modifier.fillMaxSize().padding(25.dp),
            ){
                Text(text = todo.task)
            }
        }

    }

}

data class Todo(val task:String)

@RequiresApi(Build.VERSION_CODES.O)
fun someFakeTodos():List<Todo>{
    return listOf(
        Todo("Do something, do epic shit, don't give up bhai, eito hocche"),
        Todo("Do coding, Go to Gym, lege thakle menge khabi na"),
        Todo("Do MVVM"),
        Todo("Do Jetpack Compose"),
        Todo("Do Kotlin and Kotlin Multiplatform"),
        Todo("Do XML"),

        )
}