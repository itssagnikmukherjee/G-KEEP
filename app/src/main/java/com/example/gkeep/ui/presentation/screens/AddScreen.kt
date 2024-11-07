package com.example.gkeep.ui.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gkeep.R
import com.example.gkeep.ui.theme.myGrey
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Preview
@Composable
fun AddScreenUI() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(myGrey)
            .padding(10.dp),
        contentAlignment = Alignment.Center,
    ){
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                TextField(value = "", onValueChange = {}, modifier = Modifier.padding(start = 20.dp).fillMaxWidth(0.82f),
                    placeholder = { Text(text = "Title", fontSize = 30.sp)},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.Transparent,
                    )
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "", modifier = Modifier.size(40.dp))
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(value = "", onValueChange = {}, placeholder = { Text(text = "Note")}, modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(0.93f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = myGrey,
                    unfocusedBorderColor = myGrey,
                    focusedContainerColor = Color.White.copy(0.3f),
                    unfocusedContainerColor = Color.White.copy(0.5f)
                ),
                shape = RoundedCornerShape(10.dp),
                )
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .align(alignment = Alignment.BottomEnd)
            .padding(10.dp)) {
            Icon(imageVector = Icons.Default.Check, contentDescription = "")
        }
    }

}

@Composable
fun AddTodoSec(){
    var showAddScreen by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp, 60.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        Button(onClick = {
            showAddScreen = !showAddScreen
        }
            , modifier = Modifier.size(80.dp), shape = RoundedCornerShape(25.dp)){
            Icon(painter = painterResource(id = R.drawable.add_outline), contentDescription = "", modifier = Modifier.size(90.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatenTimeSec(){
    var nofTodos = someFakeTodos().size
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
            Text(text = "6/${nofTodos}", fontSize = 18.sp, modifier = Modifier.padding(4.dp, end = 3.dp))
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