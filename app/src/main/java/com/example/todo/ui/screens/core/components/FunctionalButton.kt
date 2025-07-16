package com.example.todo.ui.screens.core.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FunctionalButton(
    text: String, onClick: () -> Unit
) {
    Button(
        onClick = { onClick() }, modifier = Modifier
            .width(325.dp)
            .height(60.dp)
    ) {
        Text(
            text = text, fontSize = 32.sp
        )
    }
}