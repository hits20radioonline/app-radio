package com.hits20radio.online.v2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
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
        val volumeBar = findViewById<SeekBar>(R.id.volumeBar)
        val radioTab = findViewById<Button>(R.id.radioTab)
        val videoTab = findViewById<Button>(R.id.videoTab)

        // Inicializar ExoPlayer con tu URL real
        try {
            player = ExoPlayer.Builder(this).build().apply {
                val mediaItem = MediaItem.fromUri("https://stream.radiosmundiales.com:8692/stream")
                setMediaItem(mediaItem)
                prepare()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Botón Play / Pause
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

        // Control de Volumen
        volumeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val volume = progress / 100f
                player?.volume = volume
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Pestaña Radio
        radioTab.setOnClickListener {
            Toast.makeText(this, "Estás en HITS20 RADIO", Toast.LENGTH_SHORT).show()
        }

        // Pestaña Video
        videoTab.setOnClickListener {
            Toast.makeText(this, "Cargando sección de Video...", Toast.LENGTH_SHORT).show()
            // Aquí puedes abrir un enlace web o una actividad de video si lo deseas
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://hits20radioonline.com"))
            startActivity(intent)
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
