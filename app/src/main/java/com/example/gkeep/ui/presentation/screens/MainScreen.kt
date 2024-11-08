package com.example.gkeep.ui.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gkeep.R
import com.example.gkeep.ui.data.database.NotesDatabase
import com.example.gkeep.ui.data.tables.Notes
import com.example.gkeep.ui.presentation.navigation.AddEditScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun MainScreenUI(navController: NavHostController, db: NotesDatabase) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DatenTimeSec()
        Box() {
            TodoGrid(db)
            AddTodoSec(navController)
        }
    }
}

@Composable
fun AddTodoSec(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp, 60.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        Button(onClick = {
            navController.navigate(AddEditScreen)
        }
            , modifier = Modifier.size(80.dp), shape = RoundedCornerShape(25.dp)){
            Icon(painter = painterResource(id = R.drawable.add_outline), contentDescription = "", modifier = Modifier.size(90.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatenTimeSec(){
    var currentTime by remember { mutableStateOf(LocalDateTime.now()) }
    val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")
    val dateFormatter = DateTimeFormatter.ofPattern("dd MMM")
    val formattedTime = currentTime.format(timeFormatter)
    val formattedDate = currentTime.format(dateFormatter)

    LaunchedEffect(key1 = Unit) {
        while (true) {
            currentTime = LocalDateTime.now()
            delay(1000)
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ){
        Column {
            Text(text = "Mon", fontSize = 40.sp)
            Text(text = "${formattedDate}", fontSize = 28.sp)
            Text(text = "${formattedTime}", fontSize = 18.sp)
        }
        Column (
            modifier = Modifier
                .height(90.dp)
                .padding(start = 20.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Create, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                }
            }
            LinearProgressBarDemo()
        }
    }

}


@Composable
fun LinearProgressBarDemo() {
    LinearProgressIndicator(
        progress = { 0.6f },
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .clip(RoundedCornerShape(20.dp)),
        color = Color.Green
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoGrid(db: NotesDatabase) {
    val todo by db.dao().getNotes().collectAsState(initial = emptyList())
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.padding(20.dp)
    ) {
        if (todo.size == 0){
            item {
                Text(text = "No Notes")
            }
        }
        items(todo.size) { noteIndex ->
            TodoCard(todo[noteIndex], db)
        }
    }
}


@Composable
fun TodoCard(note: Notes, db: NotesDatabase) {
    var coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxWidth().padding(10.dp),
        contentAlignment = Alignment.Center) {
        Card(onClick = {}) {
            Box(modifier = Modifier.fillMaxSize().padding(25.dp)) {
//                Text(text = note.title)
                    Text(text = note.noteTxt)
                    IconButton(onClick = {
                        coroutineScope.launch { db.dao().deleteNote(note) }
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "")
                    }
            }
        }
    }
}