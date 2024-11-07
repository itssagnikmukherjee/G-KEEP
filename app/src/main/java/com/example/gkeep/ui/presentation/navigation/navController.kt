package com.example.gkeep.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gkeep.ui.data.database.NotesDatabase
import com.example.gkeep.ui.presentation.screens.AddEditScreeUI
import com.example.gkeep.ui.presentation.screens.MainScreenUI

@Composable
fun AppNavigation(db: NotesDatabase) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreen,
    ){
        composable<MainScreen> { MainScreenUI(navController,db) }
        composable<AddEditScreen> { AddEditScreeUI(navController,db) }
    }
}