package com.hydratech.mvvmpracticepart2withroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hydratech.mvvmpracticepart2withroom.repository.QuoteRepository
import com.hydratech.mvvmpracticepart2withroom.room.Quotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository) : ViewModel() {

    fun getQuotes() : LiveData<List<Quotes>>{
        return repository.getQuotes()
    }

    fun insertQuote(quotes: Quotes){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuotes(quotes)
        }
    }
}