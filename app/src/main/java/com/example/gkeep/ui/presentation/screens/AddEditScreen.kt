package com.example.gkeep.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gkeep.ui.data.database.NotesDatabase
import com.example.gkeep.ui.data.tables.Notes
import com.example.gkeep.ui.presentation.navigation.MainScreen
import com.example.gkeep.ui.theme.myGrey
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@OptIn(DelicateCoroutinesApi::class)
@Composable
fun AddEditScreeUI(navController: NavHostController, db: NotesDatabase) {
    var title by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
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
                TextField(value = title, onValueChange = {title=it}, modifier = Modifier.padding(start = 20.dp).fillMaxWidth(0.82f),
                    placeholder = { Text(text = "Title", fontSize = 30.sp) },
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
            OutlinedTextField(value = note, onValueChange = {note=it}, placeholder = { Text(text = "Note") }, modifier = Modifier
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
        Button(onClick = {
            GlobalScope.launch { db.dao().upsertNote(Notes(0,note,title,"")) }
            navController.navigate(MainScreen)
        }, modifier = Modifier
            .align(alignment = Alignment.BottomEnd)
            .padding(10.dp)) {
            Icon(imageVector = Icons.Default.Check, contentDescription = "")
        }
    }
}
