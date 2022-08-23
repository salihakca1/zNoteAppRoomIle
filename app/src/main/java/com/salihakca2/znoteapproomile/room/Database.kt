package com.salihakca2.znoteapproomile.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salihakca2.znoteapproomile.data.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class Database: RoomDatabase() {
        abstract fun getNotesDao(): NotesDao
}