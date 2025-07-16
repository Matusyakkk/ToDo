package com.example.todo.di

import android.content.Context
import androidx.room.Room
import com.example.todo.data.dao.LocalToDoDao
import com.example.todo.data.database.LocalToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalToDoModule {

    @Provides
    fun provideLocalToDoDatabase(@ApplicationContext context: Context): LocalToDoDatabase {
        return Room.databaseBuilder(context, LocalToDoDatabase::class.java, "ToDos").build()
    }

    @Provides
    fun provideLocalToDoDao(localToDoDatabase: LocalToDoDatabase): LocalToDoDao {
        return localToDoDatabase.toDoDao()
    }

}