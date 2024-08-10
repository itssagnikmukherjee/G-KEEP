package com.example.gkeep

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gkeep.ui.theme.myGrey

@Preview
@Composable
fun AddScreen() {
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