package com.example.todo.data.repository

import com.example.todo.data.model.ToDo
import com.example.todo.data.dao.LocalToDoDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalToDoRepository @Inject constructor(
    private val toDoDao: LocalToDoDao
) {
    suspend fun insertToDo(todo: ToDo): Long {
        return toDoDao.insertToDo(todo)
    }

    suspend fun updateToDo(todo: ToDo) {
        toDoDao.updateToDo(todo)
    }

    suspend fun deleteToDo(todo: ToDo) {
        toDoDao.deleteToDo(todo)
    }

    fun getToDos(): Flow<List<ToDo>> = toDoDao.getToDos()
}