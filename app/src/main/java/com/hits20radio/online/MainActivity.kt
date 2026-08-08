package com.hits20radio.online

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.hits20radio.online.R.layout.activity_main)

        val playBtn = findViewById<Button>(com.hits20radio.online.R.id.play)
        val statusText = findViewById<TextView>(com.hits20radio.online.R.id.status)
        val videoBtn = findViewById<Button>(com.hits20radio.online.R.id.videoBtn)
        val settingsBtn = findViewById<Button>(com.hits20radio.online.R.id.settings)

        playBtn.setOnClickListener {
            statusText.text = "TRANSMITIENDO EN VIVO..."
            playBtn.text = "⏸ PAUSAR HITS20"
        }

        videoBtn.setOnClickListener {
            // Acción de video
        }

        settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
