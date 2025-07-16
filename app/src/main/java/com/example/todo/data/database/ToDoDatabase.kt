package com.example.todo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.data.dao.LocalToDoDao
import com.example.todo.data.model.ToDo

@Database(entities = [ToDo::class], version = 1, exportSchema = false)
abstract class LocalToDoDatabase: RoomDatabase() {
    abstract fun toDoDao(): LocalToDoDao
}