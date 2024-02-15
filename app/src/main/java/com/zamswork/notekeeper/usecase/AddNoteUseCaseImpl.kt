package com.zamswork.notekeeper.usecase

import com.zamswork.notekeeper.domain.model.Note
import com.zamswork.notekeeper.domain.repository.NoteRepository
import com.zamswork.notekeeper.domain.usecase.AddNoteUseCase
import javax.inject.Inject

class AddNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
): AddNoteUseCase {
    override suspend fun invoke(input: Note): Boolean {
       return noteRepository.addNote(input)
    }
}