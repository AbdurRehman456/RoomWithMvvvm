package com.hydratech.mvvmpracticepart2withroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quotes::class] , version = 1)
abstract class QuotesDataBase : RoomDatabase() {
    abstract fun quoteDao() : QuotesDao
    companion object{
       private var INSTANCE: QuotesDataBase? = null

        fun getDatabase(context: Context):QuotesDataBase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuotesDataBase::class.java,
                        "quote_database"
                    ).createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}