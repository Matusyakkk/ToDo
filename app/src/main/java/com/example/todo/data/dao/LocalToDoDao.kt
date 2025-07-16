package com.example.todo.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todo.data.model.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalToDoDao {

    @Insert(onConflict = OnConflictStrategy.Companion.NONE)
    suspend fun insertToDo(todo: ToDo): Long

    @Update
    suspend fun updateToDo(todo: ToDo)

    @Delete
    suspend fun deleteToDo(todo: ToDo)

    @Query("SELECT * FROM todos ORDER BY id DESC")
    fun getToDos(): Flow<List<ToDo>>
}