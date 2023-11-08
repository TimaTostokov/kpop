package com.example.my.kpop

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.my.kpop.databinding.ActivityMainBinding
import com.example.my.kpop.model.KPopModel
import com.example.my.kpop.presenter.KPopPresenter
import com.example.my.kpop.view.KPopView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback

class MainActivity : AppCompatActivity(), KPopView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: KPopPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initClickers()
        lifecycle.addObserver(binding.youtubePlayerView)
    }

    private fun initClickers() {
        binding.btnSong.setOnClickListener {
            presenter.getSong(binding.etSong.text.toString().trim())
        }
    }

    override fun setVideo(kPopModel: KPopModel) {
        kPopModel.data.firstOrNull()?.let { firstItem ->
            binding.youtubePlayerView.getYoutubePlayerWhenReady(object : YouTubePlayerCallback {
                override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                    val songId = firstItem.video.replace("https://youtube.be/", "")
                    youTubePlayer.loadVideo(songId, 0f)
                }
            })
            binding.tvArtistName.text = firstItem.artist
            binding.tvSongName.text = firstItem.songName
        } ?: showError("No video found")
    }

    override fun showError(message: String) {
        Log.e("ololo", "showError: ${message}")
        Toast.makeText(this, "Error service", Toast.LENGTH_SHORT).show()
    }

}