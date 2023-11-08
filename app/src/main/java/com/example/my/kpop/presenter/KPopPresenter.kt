package com.example.my.kpop.presenter

import com.example.my.kpop.model.KPopModel
import com.example.my.kpop.model.RetrofitService
import com.example.my.kpop.view.KPopView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KPopPresenter(private val kPopView: KPopView) {

    fun getSong(songName: String) {
        RetrofitService().api.getSong(songName).enqueue(object : Callback<KPopModel> {
            override fun onResponse(call: Call<KPopModel>, response: Response<KPopModel>) {
                val kPopModel = response.body()
                if (kPopModel != null) {
                    kPopView.setVideo(kPopModel)
                } else {
                    kPopView.showError("Response is null")
                }
            }

            override fun onFailure(call: Call<KPopModel>, t: Throwable) {
                kPopView.showError(t.message.toString())
            }
        })
    }

}