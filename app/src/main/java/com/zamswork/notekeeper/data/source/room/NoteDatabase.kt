package com.zamswork.notekeeper.data.source.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zamswork.notekeeper.data.source.room.converters.RoomTypeConverter
import com.zamswork.notekeeper.data.source.room.dao.NoteDao
import com.zamswork.notekeeper.data.source.room.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false,)
@TypeConverters(RoomTypeConverter::class)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun getNoteDao(): NoteDao


}