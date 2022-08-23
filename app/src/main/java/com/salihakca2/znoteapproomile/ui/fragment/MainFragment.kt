package com.salihakca2.znoteapproomile.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.salihakca2.znoteapproomile.R
import com.salihakca2.znoteapproomile.databinding.FragmentMainBinding
import com.salihakca2.znoteapproomile.gecisYap
import com.salihakca2.znoteapproomile.ui.adapter.NoteAdapter
import com.salihakca2.znoteapproomile.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var design: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)   //Databinding aktif hale getirdik

        design.mainFragment = this
        design.mainToolbarTitle = "Notes"

        (activity as AppCompatActivity).setSupportActionBar(design.toolbarMainFragment)


        viewModel.noteList.observe(viewLifecycleOwner){
            val adapter = NoteAdapter(requireContext(),it, viewModel)
            design.notesAdapter = adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return false
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(it: View){
        //Navigation.findNavController(it).navigate(R.id.noteRecordFragment)
        Navigation.gecisYap(it,R.id.noteRecordTransition)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
            viewModel.noteSearching(query)
            return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
            viewModel.noteSearching(newText)
            return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.allNotes()
    }

}