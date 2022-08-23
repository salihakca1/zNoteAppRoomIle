package com.salihakca2.znoteapproomile.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.salihakca2.znoteapproomile.data.repo.NotesDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(var nrepo: NotesDaoRepository): ViewModel() {

    fun update(noteId: Int, noteTitle: String, note: String){
            nrepo.noteUpdate(noteId, noteTitle, note)
    }
    fun delete(noteId:Int){
            nrepo.noteDelete(noteId)
    }
}