package com.example.TvShowApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.TvShowApp.R
import com.example.TvShowApp.adapters.TvShowListAdapter
import com.example.TvShowApp.viewModel.EpisodeDateViewModel

class MainActivity : AppCompatActivity() {

    lateinit var tvShowList : RecyclerView

    lateinit var tvShowSearch : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvShowList =findViewById(R.id.tvshow_list)
        tvShowSearch = findViewById(R.id.tvShow_search)


        val viewModel = ViewModelProvider(this).get(EpisodeDateViewModel::class.java)

        viewModel.tvShowsList.observe(this){
            tvShowList.layoutManager = LinearLayoutManager(this)
            tvShowList.adapter = TvShowListAdapter(it)
        }

        tvShowSearch.addTextChangedListener {
            val query = tvShowSearch.text.toString().trim()
            viewModel.loadTvShows(query)
        }

        viewModel.loadTvShows()
    }
}