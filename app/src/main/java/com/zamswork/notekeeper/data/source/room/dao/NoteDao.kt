package com.zamswork.notekeeper.data.source.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.zamswork.notekeeper.data.source.room.entities.NoteEntity
import com.zamswork.notekeeper.domain.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(vararg noteEntity: NoteEntity)

    @Query("delete from notes where note_id=:noteId")
    suspend fun deleteNote(noteId: Int)

    @Query("delete from notes")
    suspend fun deleteAllNotes()

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Query("select * from notes where note_id=:noteId")
    suspend fun getNoteById(noteId : Int) : NoteEntity?

    @Query("select * from notes")
    fun getAllNotes(): List<NoteEntity>


    @Query("select * from notes where note_title like :query or note_body like :query")
    fun searchNotes(query: String): List<NoteEntity>

}