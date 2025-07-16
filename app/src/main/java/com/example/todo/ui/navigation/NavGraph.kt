package com.example.todo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.ui.screens.create_todo.CreateToDoScreen
import com.example.todo.ui.screens.list_todos.ToDosScreen

@Composable
fun NavGraph(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list", modifier = modifier) {
        composable("list") {
            ToDosScreen(navController)
        }
        composable("create") { CreateToDoScreen(navController) }
    }
}