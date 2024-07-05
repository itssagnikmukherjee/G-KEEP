package com.example.gkeep

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


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
            horizontalAlignment = Alignment.End
        ){
            Text(text = "Todo : ${nofTodos}", fontSize = 22.sp)
            Text(text = "Done: 1", fontSize = 18.sp)
        }
    }

}