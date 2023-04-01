package com.example.tuteve.network

import com.example.tuteve.models.TVShowResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.episodate.com/api/"

interface EpisodeDateService{

//     most-popular?page=:page  = esto basicamente
    @GET("most-popular")
    suspend fun getTvShows(@Query("page") page: Int) : TVShowResponse

}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object EpisodeDateClient{
    val service: EpisodeDateService by lazy {
        retrofit.create(EpisodeDateService::class.java)
    }
}