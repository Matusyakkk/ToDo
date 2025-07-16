package com.example.todo.ui.screens.list_todos.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SwipeToDismissComponent(
    onDelete: () -> Unit,
    onUpdate: () -> Unit,
    isDone: Boolean,
    content: @Composable (RowScope.() -> Unit)
) {
    val swipeToDismissBoxState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            if (it == SwipeToDismissBoxValue.EndToStart) {
                onDelete()
                true
            } else if (it == SwipeToDismissBoxValue.StartToEnd) {
                onUpdate()
                true
            } else false
        })

    SwipeToDismissBox(
        state = swipeToDismissBoxState,
        enableDismissFromStartToEnd = !isDone,
        modifier = Modifier.fillMaxSize(),
        backgroundContent = {
            when (swipeToDismissBoxState.dismissDirection) {
                SwipeToDismissBoxValue.StartToEnd -> {
                    Icon(
                        imageVector = Icons.Outlined.Done,
                        contentDescription = "Done",
                        tint = Color.Cyan,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.CenterStart)
                            .padding(4.dp)
                    )
                }

                SwipeToDismissBoxValue.EndToStart -> {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.CenterEnd)
                            .padding(4.dp)
                    )
                }

                else -> {}
            }
        },
        content = content
    )
}