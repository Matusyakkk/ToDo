package com.example.todo.ui.screens.list_todos.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.data.model.ToDo

@Composable
fun ToDoListCard(todo: ToDo) {
    Card(
        enabled = !todo.isDone, onClick = { }, colors = CardDefaults.cardColors(
            contentColor = Color(0xFF3C85A9)
        ), modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = todo.text, fontSize = 24.sp, modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
            if (todo.isDone) Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "Is Done",
                modifier = Modifier
                    .padding(8.dp)
                    .size(28.dp)
            )
        }
    }
    HorizontalDivider(
        Modifier.padding(
            start = 32.dp, end = 32.dp, bottom = 4.dp, top = 4.dp
        )
    )
}