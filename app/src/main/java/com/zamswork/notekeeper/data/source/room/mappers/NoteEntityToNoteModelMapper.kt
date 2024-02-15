package com.zamswork.notekeeper.data.source.room.mappers

import com.zamswork.notekeeper.data.source.room.entities.NoteEntity
import com.zamswork.notekeeper.domain.model.Note

object NoteEntityToNoteModelMapper : EntityModelMapper<NoteEntity, Note> {
    override fun convertEntityToModel(entity: NoteEntity): Note {

        return Note(
            id = entity.noteId,
            title = entity.noteTitle,
            content = entity.noteContent,
            createdOn = entity.createdAt
        )
    }

    override fun convertModelToEntity(model: Note): NoteEntity {
        return NoteEntity(
            noteId = model.id,
            noteTitle = model.title,
            noteContent = model.content,
            createdAt = model.createdOn
        )
    }
}