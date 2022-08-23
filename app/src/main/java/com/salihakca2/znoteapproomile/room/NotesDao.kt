package com.salihakca2.znoteapproomile.room

import androidx.room.*
import com.salihakca2.znoteapproomile.data.entity.Note

@Dao
interface NotesDao {
        @Query("SELECT * FROM note")
        suspend fun allNotes(): List<Note>

        @Query("SELECT * FROM note WHERE noteTitle like '%' || :searchWord || '%' ")
        suspend fun noteSearch(searchWord: String): List<Note>

        @Insert
        suspend fun noteAdd(note: Note)

        @Update
        suspend fun noteUpdate(note: Note)

        @Delete
        suspend fun noteDelete(note: Note)
}