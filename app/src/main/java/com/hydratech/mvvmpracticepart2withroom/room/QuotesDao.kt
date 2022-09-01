package com.hydratech.mvvmpracticepart2withroom.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuotesDao {
    @Query("select * from quotes")
    fun getQuotes() : LiveData<List<Quotes>>

    @Insert
    suspend fun insertQuotes(quotes: Quotes)
}