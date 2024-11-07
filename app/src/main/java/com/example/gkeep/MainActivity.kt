package com.example.gkeep

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.gkeep.ui.data.database.databaseInstance
import com.example.gkeep.ui.presentation.navigation.AppNavigation
import com.example.gkeep.ui.theme.GKEEPTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val db = databaseInstance.getDB(this)
            GKEEPTheme {
                AppNavigation(db)
            }
        }
    }
}

