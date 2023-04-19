package com.example.TvShowApp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.TvShowApp.models.TVShowSummary
import com.example.TvShowApp.network.EpisodeDateClient
import kotlinx.coroutines.launch

class EpisodeDateViewModel : ViewModel() {


    val tvShowsList = MutableLiveData<List<TVShowSummary>>()

    fun loadTvShows(query:String = ""){
        viewModelScope.launch {
           val result =  if(query.isNotEmpty()){
               EpisodeDateClient.service.searchTvShows(query,1)
           }else{
               EpisodeDateClient.service.getTvShows(1)
           }
            tvShowsList.postValue(result.tvShows)
        }
    }
}