package com.zamswork.notekeeper.data.source.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    val noteId : Int = 0,

    @ColumnInfo(name = "note_title")
    val noteTitle : String,

    @ColumnInfo(name = "note_body")
    val noteContent : String,

    @ColumnInfo(name = "created_at")
    val createdAt : Date
)
