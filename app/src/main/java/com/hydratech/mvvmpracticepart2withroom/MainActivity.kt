package com.hydratech.mvvmpracticepart2withroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hydratech.mvvmpracticepart2withroom.databinding.ActivityMainBinding
import com.hydratech.mvvmpracticepart2withroom.repository.QuoteRepository
import com.hydratech.mvvmpracticepart2withroom.room.Quotes
import com.hydratech.mvvmpracticepart2withroom.room.QuotesDao
import com.hydratech.mvvmpracticepart2withroom.room.QuotesDataBase
import com.hydratech.mvvmpracticepart2withroom.viewmodel.MainViewModel
import com.hydratech.mvvmpracticepart2withroom.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        val quotesDao = QuotesDataBase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(quotesDao)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.getQuotes().observe(this, Observer {
            binding.quotes = it.toString()
        })
        binding.addQuotes.setOnClickListener {
            val quotes = Quotes(0,"testing intery","abdul")
            mainViewModel.insertQuote(quotes)
        }
    }
}