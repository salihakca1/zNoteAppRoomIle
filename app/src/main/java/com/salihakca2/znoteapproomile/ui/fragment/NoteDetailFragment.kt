package com.salihakca2.znoteapproomile.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.salihakca2.znoteapproomile.R
import com.salihakca2.znoteapproomile.databinding.FragmentMainBinding
import com.salihakca2.znoteapproomile.databinding.FragmentNoteDetailBinding
import com.salihakca2.znoteapproomile.ui.viewmodel.NoteDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {
    private lateinit var design: FragmentNoteDetailBinding
    private lateinit var viewModel: NoteDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_note_detail,container,false)

        design.noteDetailFragment = this

        design.noteDetailToolbarTitle = "Note Detail"

        val bundle: NoteDetailFragmentArgs by navArgs()
        val bundleNote = bundle.note

        design.noteObject = bundleNote

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NoteDetailViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun fabUpdate(noteId: Int, noteTitle: String, note: String){
        viewModel.update(noteId, noteTitle, note)
    }

    fun fabDelete(noteId: Int){
        viewModel.delete(noteId)
    }
}