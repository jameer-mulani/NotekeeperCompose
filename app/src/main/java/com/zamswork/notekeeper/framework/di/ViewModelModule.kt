package com.zamswork.notekeeper.framework.di

import com.zamswork.notekeeper.domain.repository.NoteRepository
import com.zamswork.notekeeper.domain.usecase.AddNoteUseCase
import com.zamswork.notekeeper.domain.usecase.GetAllNoteUseCase
import com.zamswork.notekeeper.usecase.AddNoteUseCaseImpl
import com.zamswork.notekeeper.usecase.GetAllNoteUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideGetAllNotesUseCase(noteRepository: NoteRepository) : GetAllNoteUseCase = GetAllNoteUseCaseImpl(noteRepository)

    @Provides
    fun provideAddNoteUseCase(noteRepository: NoteRepository) : AddNoteUseCase = AddNoteUseCaseImpl(noteRepository)


}