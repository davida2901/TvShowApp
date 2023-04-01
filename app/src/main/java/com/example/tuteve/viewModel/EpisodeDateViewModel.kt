package com.example.tuteve.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuteve.models.TVShowSummary
import com.example.tuteve.network.EpisodeDateClient
import kotlinx.coroutines.launch

class EpisodeDateViewModel : ViewModel() {


    val tvShowsList = MutableLiveData<List<TVShowSummary>>()

    fun loadTvShows(){
        viewModelScope.launch {
           val result =  EpisodeDateClient.service.getTvShows(1)
            tvShowsList.postValue(result.tvShows)
        }
    }
}