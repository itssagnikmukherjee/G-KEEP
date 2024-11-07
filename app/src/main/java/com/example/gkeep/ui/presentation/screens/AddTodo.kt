package com.example.gkeep.ui.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gkeep.R

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