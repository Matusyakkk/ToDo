package com.example.todo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class ToDo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String = "",
    var isDone: Boolean = false
)