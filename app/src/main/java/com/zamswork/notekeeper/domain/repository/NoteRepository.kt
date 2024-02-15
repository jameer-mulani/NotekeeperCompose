package com.zamswork.notekeeper.domain.repository

import com.zamswork.notekeeper.domain.model.Note


interface NoteRepository {

    suspend fun addNote(vararg note : Note) : Boolean

    suspend fun deleteAllNotes() : Boolean

    suspend fun getNoteById(id : Int) : Note?

    suspend fun getAllNotes() : List<Note>

    suspend fun updateNote(note: Note) : Note

    suspend fun searchNote(searchQuery : String) : List<Note>

}