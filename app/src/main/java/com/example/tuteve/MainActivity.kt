package com.example.tuteve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuteve.adapters.TvShowListAdapter
import com.example.tuteve.viewModel.EpisodeDateViewModel

class MainActivity : AppCompatActivity() {

    lateinit var tvShowList : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvShowList =findViewById(R.id.tvshow_list)


        val viewModel = ViewModelProvider(this).get(EpisodeDateViewModel::class.java)

        viewModel.tvShowsList.observe(this){
            tvShowList.layoutManager = LinearLayoutManager(this)
            tvShowList.adapter = TvShowListAdapter(it)
        }
        viewModel.loadTvShows()
    }
}