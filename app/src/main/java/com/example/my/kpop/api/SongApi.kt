package com.example.my.kpop.api

import com.example.my.kpop.model.KPopModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SongApi {
    @GET("songs")
    fun getSong(
    @Query("q") songsName: String,
    @Query("by") by: String = "Song Name",
    @Header("X-RapidAPI-Key") key: String = "78bb8ecc8dmsha71f7db1db6c66cp1338f5jsn2ae3a25d70d2",
    @Header("X-RapidAPI-Host") host: String = "k-pop.p.rapidapi.com"
    ):Call<KPopModel>

}
