package com.zamswork.notekeeper.domain.usecase

import com.zamswork.notekeeper.domain.model.Note

interface AddNoteUseCase : SuspendUseCase<Note, Boolean>

interface GetAllNoteUseCase : SuspendUseCase<Int?, List<Note>>

interface DeleteAllNoteUseCase : SuspendUseCase<Int?, Boolean>

interface GetNoteByIdUseCase : SuspendUseCase<Int, Note?>

interface UpdateNoteUseCase : SuspendUseCase<Note, Note>

interface SearchNote : SuspendUseCase<String, List<Note>>