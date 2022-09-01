package com.hydratech.mvvmpracticepart2withroom.repository

import androidx.lifecycle.LiveData
import com.hydratech.mvvmpracticepart2withroom.room.Quotes
import com.hydratech.mvvmpracticepart2withroom.room.QuotesDao


class QuoteRepository(private val quotesDao: QuotesDao) {

    fun getQuotes() : LiveData<List<Quotes>>{
        return quotesDao.getQuotes()
    }

   suspend fun insertQuotes(quotes: Quotes){
        quotesDao.insertQuotes(quotes)
    }
}