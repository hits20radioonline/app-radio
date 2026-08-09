package com.hits20radio.online.v2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.gauravk.audiovisualizer.visualizer.BarVisualizer

class MainActivity : ComponentActivity() {
    private var player: ExoPlayer? = null
    private var isPlaying: Boolean = false
    private var visualizer: BarVisualizer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn = findViewById<ImageButton>(R.id.play)
        val songTitle = findViewById<TextView>(R.id.songTitle)
        val volumeBar = findViewById<SeekBar>(R.id.volumeBar)
        val videoTab = findViewById<Button>(R.id.videoTab)
        
        val btnFacebook = findViewById<LinearLayout>(R.id.btnFacebook)
        val btnInstagram = findViewById<LinearLayout>(R.id.btnInstagram)
        val btnWhatsapp = findViewById<LinearLayout>(R.id.btnWhatsapp)
        val btnWeb = findViewById<LinearLayout>(R.id.btnWeb)

        // Inicializar el Vúmetro / Visualizador dinámico
        visualizer = findViewById(R.id.visualizer)

        // Inicializar ExoPlayer y conectar el audio al visualizador
        try {
            player = ExoPlayer.Builder(this).build().apply {
                val mediaItem = MediaItem.fromUri("https://stream.radiosmundiales.com:8692/stream")
                setMediaItem(mediaItem)
                prepare()
                play()
                
                // Conectamos la sesión de audio del reproductor al visualizador para que se mueva al compás
                val audioSessionId = audioSessionId
                if (audioSessionId != C.AUDIO_SESSION_ID_UNSET) {
                    visualizer?.setAudioSessionId(audioSessionId)
                }
            }
            isPlaying = true
            playBtn.setImageResource(R.drawable.ic_pause_circle)
            songTitle.text = "HITS20 RADIO ONLINE"
        } catch (e: Exception) {
            e.printStackTrace()
        }

        playBtn.setOnClickListener {
            if (isPlaying) {
                player?.pause()
                playBtn.setImageResource(R.drawable.ic_play_circle)
                songTitle.text = "PAUSADO"
                isPlaying = false
            } else {
                player?.play()
                playBtn.setImageResource(R.drawable.ic_pause_circle)
                songTitle.text = "HITS20 RADIO ONLINE"
                isPlaying = true
            }
        }

        volumeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                player?.volume = progress / 100f
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btnWeb.setOnClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://hits20radioonline.com"))) }
        btnFacebook.setOnClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"))) }
        btnInstagram.setOnClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com"))) }
        btnWhatsapp.setOnClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://whatsapp.com"))) }

        videoTab.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://hits20radioonline.com")))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberar recursos del visualizador y reproductor
        visualizer?.release()
        player?.release()
        player = null
    }
}
