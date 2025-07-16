package com.example.todo.ui.screens.create_todo

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todo.ui.screens.core.components.FunctionalButton
import com.example.todo.ui.viewmodel.ViewModel

@Composable
fun CreateToDoScreen(navController: NavController, modifier: Modifier = Modifier) {
    val activity = LocalContext.current as ComponentActivity
    val vm: ViewModel = hiltViewModel(activity)
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("ToDo") },
            modifier = Modifier
                .width(325.dp)
                .heightIn(min = 120.dp, max = 320.dp),
            shape = RoundedCornerShape(30.dp),
            textStyle = TextStyle(fontSize = 24.sp)
        )

        Spacer(Modifier.height(8.dp))

        FunctionalButton("Create new ToDo") {
            if (text.isNotBlank()) {
                vm.addToDo(text)
                navController.navigate("list")
                text = ""
            }
        }
    }
}