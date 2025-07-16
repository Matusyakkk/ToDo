package com.example.todo.ui.screens.list_todos

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todo.ui.screens.core.components.FunctionalButton
import com.example.todo.ui.screens.list_todos.components.SwipeToDismissComponent
import com.example.todo.ui.screens.list_todos.components.ToDoListCard
import com.example.todo.ui.viewmodel.ViewModel

@Composable
fun ToDosScreen(navController: NavController, modifier: Modifier = Modifier) {
    val activity = LocalContext.current as ComponentActivity
    val vm: ViewModel = hiltViewModel(activity)
    val todoList by vm.todos.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(todoList) { todo ->
                SwipeToDismissComponent(
                    onDelete = { vm.deleteToDo(todo) },
                    onUpdate = { vm.updateToDo(todo.copy(isDone = true)) },
                    isDone = todo.isDone
                ) {
                    ToDoListCard(todo)
                }
            }
        }
        FunctionalButton("Create") { navController.navigate("create") }
    }
}