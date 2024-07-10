package com.example.gkeep

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Preview
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