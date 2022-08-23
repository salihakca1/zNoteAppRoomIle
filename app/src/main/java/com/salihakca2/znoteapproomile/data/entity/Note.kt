package com.salihakca2.znoteapproomile.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "note")
data class Note(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "noteId") @NotNull var noteId: Int,
                @ColumnInfo(name = "noteTitle") @NotNull var noteTitle: String,
                @ColumnInfo(name = "note") @NotNull var note: String): Serializable {
}