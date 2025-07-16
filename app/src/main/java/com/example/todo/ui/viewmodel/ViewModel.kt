package com.example.todo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.repository.LocalToDoRepository
import com.example.todo.data.model.ToDo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val localToDoRepository: LocalToDoRepository
): ViewModel() {

    private val _todos = MutableStateFlow<List<ToDo>>(emptyList())
    val todos: StateFlow<List<ToDo>> = _todos.asStateFlow()

    init {
        viewModelScope.launch {
            localToDoRepository.getToDos().collect { todos ->
                _todos.value = todos
            }
        }
    }

    fun addToDo(text: String) {
        val toDo = ToDo(text = text)
        viewModelScope.launch {
            localToDoRepository.insertToDo(toDo)
        }
    }

    fun updateToDo(toDo: ToDo) {
        viewModelScope.launch {
            localToDoRepository.updateToDo(toDo)
        }
    }

    fun deleteToDo(toDo: ToDo) {
        viewModelScope.launch {
            localToDoRepository.deleteToDo(toDo)
        }
    }
}