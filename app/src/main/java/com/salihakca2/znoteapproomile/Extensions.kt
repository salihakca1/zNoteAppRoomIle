package com.salihakca2.znoteapproomile

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun  Navigation.gecisYap(it: View, id: Int){
        findNavController(it).navigate(id)
}
fun Navigation.gecisYap(it: View, id: NavDirections){
        findNavController(it).navigate(id)
}