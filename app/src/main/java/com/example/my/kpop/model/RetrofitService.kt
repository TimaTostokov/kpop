package com.example.my.kpop.model

import com.example.my.kpop.api.SongApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    var retrofit = Retrofit.Builder().baseUrl("http://k-pop.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(SongApi::class.java)
}