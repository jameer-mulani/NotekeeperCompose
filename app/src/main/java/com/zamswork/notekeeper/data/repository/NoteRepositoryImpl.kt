package com.zamswork.notekeeper.data.repository

import com.zamswork.notekeeper.data.source.room.dao.NoteDao
import com.zamswork.notekeeper.data.source.room.mappers.NoteEntityToNoteModelMapper
import com.zamswork.notekeeper.domain.model.Note
import com.zamswork.notekeeper.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun addNote(vararg note: Note): Boolean {
        val map = note.map {
            NoteEntityToNoteModelMapper.convertModelToEntity(it)
        }
        noteDao.insertNote(*map.toTypedArray())
        return true
    }

    override suspend fun deleteAllNotes(): Boolean {
        noteDao.deleteAllNotes()
        return true
    }

    override suspend fun getNoteById(id: Int): Note? {
        val noteEntity = noteDao.getNoteById(id)
        noteEntity?.let {
            return NoteEntityToNoteModelMapper.convertEntityToModel(it)
        } ?: return null
    }

    override suspend fun getAllNotes(): List<Note> {
        val allNoteEntities = noteDao.getAllNotes()
        return allNoteEntities.map {
            NoteEntityToNoteModelMapper.convertEntityToModel(it)
        }
    }

    override suspend fun updateNote(note: Note): Note {
        noteDao.updateNote(NoteEntityToNoteModelMapper.convertModelToEntity(note))
        return note
    }

    override suspend fun searchNote(searchQuery: String): List<Note> {
        val searchedNoteEntities = noteDao.searchNotes(searchQuery)
        return searchedNoteEntities.map {
            NoteEntityToNoteModelMapper.convertEntityToModel(it)
        }
    }

}