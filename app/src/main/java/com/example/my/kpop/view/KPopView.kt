package com.example.my.kpop.view

import com.example.my.kpop.model.KPopModel

interface KPopView {
    fun setVideo(kPopModel: KPopModel)
    fun showError(message:String)
//    fun youtubePlayerView()
}