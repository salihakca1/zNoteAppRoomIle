package com.salihakca2.znoteapproomile.ui.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.znoteapproomile.R
import com.salihakca2.znoteapproomile.data.entity.Note
import com.salihakca2.znoteapproomile.databinding.CardDesignBinding
import com.salihakca2.znoteapproomile.gecisYap
import com.salihakca2.znoteapproomile.ui.fragment.MainFragmentDirections
import com.salihakca2.znoteapproomile.ui.viewmodel.MainViewModel

class NoteAdapter (var mContext: Context, var notesList: List<Note>, var viewModel: MainViewModel)
    :RecyclerView.Adapter<NoteAdapter.CardDesigner>(){


    inner class CardDesigner(design: CardDesignBinding): RecyclerView.ViewHolder(design.root){

        var design: CardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesigner {

        var layoutInflater= LayoutInflater.from(mContext)

        val design: CardDesignBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_design,parent,false)
        return CardDesigner(design)
    }

    override fun onBindViewHolder(holder: CardDesigner, position: Int) {
        val note = notesList.get(position)
        val d = holder.design

        d.noteObject = note

        d.lineCard.setOnClickListener {
            val transition = MainFragmentDirections.kisiDetayTransition(note = note)
            //Navigation.findNavController(it).navigate(transition)
            Navigation.gecisYap(it,transition)
        }
    }

    override fun getItemCount(): Int {
            return notesList.size
    }
}