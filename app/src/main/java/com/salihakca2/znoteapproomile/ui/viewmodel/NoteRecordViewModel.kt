package com.salihakca2.znoteapproomile.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.salihakca2.znoteapproomile.data.repo.NotesDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteRecordViewModel @Inject constructor(var nrepo: NotesDaoRepository): ViewModel() {

        fun record(noteTitle: String, note: String){
            nrepo.noteRecord(noteTitle, note)
        }
}