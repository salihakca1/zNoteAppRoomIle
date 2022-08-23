package com.salihakca2.znoteapproomile.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.salihakca2.znoteapproomile.R
import com.salihakca2.znoteapproomile.databinding.FragmentMainBinding
import com.salihakca2.znoteapproomile.databinding.FragmentNoteRecordBinding
import com.salihakca2.znoteapproomile.gecisYap
import com.salihakca2.znoteapproomile.ui.viewmodel.NoteRecordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteRecordFragment : Fragment() {
    private lateinit var design: FragmentNoteRecordBinding
    private lateinit var viewModel: NoteRecordViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_note_record,container,false)

        design.noteRecordFragment = this

        design.noteRecordToolbarTitle = "Note Record"


        return design.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NoteRecordViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonRecord(noteTitle: String, note: String){
        viewModel.record(noteTitle, note)
    }

}