package com.hits20radio.online.v2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.hits20radio.online.v2.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn = findViewById<Button>(R.id.play)
        val statusText = findViewById<TextView>(R.id.status)
        val videoBtn = findViewById<Button>(R.id.videoBtn)
        val settingsBtn = findViewById<Button>(R.id.settings)

        playBtn.setOnClickListener {
            statusText.text = "TRANSMITIENDO EN VIVO..."
            playBtn.text = "⏸ PAUSAR HITS20"
        }

        videoBtn.setOnClickListener {
            // Acción de video
        }

        settingsBtn.setOnClickListener {
            // Configuración temporalmente omitida para evitar errores
        }
    }
}
