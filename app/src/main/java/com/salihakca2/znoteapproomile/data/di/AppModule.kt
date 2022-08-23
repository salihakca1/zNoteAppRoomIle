package com.salihakca2.znoteapproomile.data.di

import android.content.Context
import androidx.room.Room
import com.salihakca2.znoteapproomile.data.repo.NotesDaoRepository
import com.salihakca2.znoteapproomile.room.Database
import com.salihakca2.znoteapproomile.room.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNotesDaoRepository(ndao: NotesDao): NotesDaoRepository{
        return NotesDaoRepository(ndao)
    }

    @Provides
    @Singleton
    fun provideNotesDao(@ApplicationContext context: Context): NotesDao{
        val db = Room.databaseBuilder(context, Database::class.java,"note.sqlite")
            .createFromAsset("note.sqlite")
            .build()

        return db.getNotesDao()
    }
}