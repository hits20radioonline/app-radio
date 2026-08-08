package com.hits20radio.online.v2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class MainActivity : ComponentActivity() {
    private var player: ExoPlayer? = null
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn = findViewById<Button>(R.id.play)
        val songTitle = findViewById<TextView>(R.id.songTitle)

        try {
            player = ExoPlayer.Builder(this).build().apply {
                val mediaItem = MediaItem.fromUri("https://stream.zeno.fm/your_stream_url")
                setMediaItem(mediaItem)
                prepare()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        playBtn.setOnClickListener {
            if (isPlaying) {
                player?.pause()
                playBtn.text = "▶"
                songTitle.text = "PAUSADO"
                isPlaying = false
            } else {
                player?.play()
                playBtn.text = "⏸"
                songTitle.text = "HITS20 RADIO ONLINE"
                isPlaying = true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            player?.release()
            player = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
