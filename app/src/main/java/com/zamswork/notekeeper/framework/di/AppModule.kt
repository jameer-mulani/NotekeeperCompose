package com.zamswork.notekeeper.framework.di

import android.content.Context
import androidx.room.Room
import com.zamswork.notekeeper.data.repository.NoteRepositoryImpl
import com.zamswork.notekeeper.data.source.room.NoteDatabase
import com.zamswork.notekeeper.data.source.room.converters.RoomTypeConverter
import com.zamswork.notekeeper.data.source.room.dao.NoteDao
import com.zamswork.notekeeper.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext contexts: Context) : NoteDatabase{
        return Room.databaseBuilder(contexts, NoteDatabase::class.java, "notedb.db")
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) : NoteDao = noteDatabase.getNoteDao()

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao) : NoteRepository = NoteRepositoryImpl(noteDao)


}