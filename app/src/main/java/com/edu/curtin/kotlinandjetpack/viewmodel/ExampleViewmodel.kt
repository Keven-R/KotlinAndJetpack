package com.edu.curtin.kotlinandjetpack.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.edu.curtin.kotlinandjetpack.R
import com.edu.curtin.kotlinandjetpack.model.Book

private const val TAG = "ExampleViewModel"

class ExampleViewmodel : ViewModel(){

    var books = mutableStateListOf<Book>()
    var randomText by mutableStateOf("")

    fun listUpdateExample(){
        books[0] = books[0].copy(title = "The Tell-Tale Heart")
    }

    init{
        populateList()
    }

    fun onEvent(event: ExampleEvent){
        when(event){
            ExampleEvent.TempEvent -> { Log.v(TAG, "Temp Event Happened")}
            is ExampleEvent.TempEventPrams -> { Log.v(TAG, "Event with ${event.pos}")}
        }
    }

    private fun populateList(){
        books.add(Book("The Black Cat","Edgar Allan Poe", R.drawable.edgar))
        books.add(Book("The Cask of Amontillado","Edgar Allan Poe", R.drawable.edgar))
        books.add(Book("A Decent into the Maelstrom","Edgar Allan Poe", R.drawable.edgar))
        books.add(Book("Lenore","Edgar Allan Poe", R.drawable.edgar))
        books.add(Book("The Raven","Edgar Allan Poe", R.drawable.edgar))
        books.add(Book("Never Bet the Devil Your Head","Edgar Allan Poe", R.drawable.edgar))
        books.add(Book("The Imp of the Perverse","Edgar Allan Poe", R.drawable.edgar))
        books.add(Book("Loss of Breath","Edgar Allan Poe", R.drawable.edgar))
        books.add(Book("The Murders in the Rue Morgue","Edgar Allan Poe", R.drawable.edgar))
    }
}