package com.salihakca2.znoteapproomile.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salihakca2.znoteapproomile.data.entity.Note
import com.salihakca2.znoteapproomile.data.repo.NotesDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var nrepo: NotesDaoRepository): ViewModel() {
        var noteList = MutableLiveData<List<Note>>()

    init {
        allNotes()
        noteList = nrepo.notesAll()
    }

    fun noteSearching(searchWord: String){
        nrepo.noteSearch(searchWord)
    }

    fun allNotes(){
        nrepo.allNotes()
    }

}