package com.salihakca2.znoteapproomile.data.repo

import androidx.lifecycle.MutableLiveData
import com.salihakca2.znoteapproomile.data.entity.Note
import com.salihakca2.znoteapproomile.room.NotesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesDaoRepository(var ndao : NotesDao) {
    var noteList: MutableLiveData<List<Note>>
    init {
        noteList = MutableLiveData()
    }

    fun notesAll(): MutableLiveData<List<Note>>{
        return noteList
    }

    fun noteRecord(noteTitle: String, note: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newNote = Note(0,noteTitle,note)
            ndao.noteAdd(newNote)
        }
    }

    fun noteUpdate(noteId: Int, noteTitle: String, note: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedNote = Note(noteId,noteTitle, note)
            ndao.noteUpdate(updatedNote)
        }
    }

    fun noteSearch(searchWord: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            noteList.value =  ndao.noteSearch(searchWord)
        }
    }

    fun noteDelete(noteId: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedNote = Note(noteId,"","")
            ndao.noteDelete(deletedNote)
            allNotes()
        }
    }

    fun allNotes(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            noteList.value = ndao.allNotes()
        }
    }

}