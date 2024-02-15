package com.zamswork.notekeeper.usecase

import com.zamswork.notekeeper.domain.model.Note
import com.zamswork.notekeeper.domain.repository.NoteRepository
import com.zamswork.notekeeper.domain.usecase.GetAllNoteUseCase
import javax.inject.Inject

class GetAllNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
) : GetAllNoteUseCase {
    override suspend fun invoke(input: Int?): List<Note> {
        return noteRepository.getAllNotes()
    }
}