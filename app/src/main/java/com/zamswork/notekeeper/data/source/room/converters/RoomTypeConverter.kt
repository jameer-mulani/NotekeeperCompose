package com.zamswork.notekeeper.data.source.room.converters

import androidx.room.TypeConverter
import java.util.Date


class RoomTypeConverter {
    @TypeConverter
    fun convertDateToLong(date: Date): Long = date.time

    @TypeConverter
    fun convertLongToDate(long: Long): Date = Date(long)
}

