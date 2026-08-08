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
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de tu diseño XML
        val playBtn = findViewById<Button>(R.id.play)
        val statusText = findViewById<TextView>(R.id.status)
        val videoBtn = findViewById<Button>(R.id.videoBtn)
        val settingsBtn = findViewById<Button>(R.id.settings)

        // Configurar botón de reproducción / radio
        playBtn.setOnClickListener {
            statusText.text = "TRANSMITIENDO..."
            // Aquí puedes enlazar la lógica de reproducción con tu PlaybackService o reproductor
        }

        // Configurar botón de video si deseas que abra una vista o enlace externo
        videoBtn.setOnClickListener {
            // Acción para el botón de video
        }

        // Configurar botón de configuración
        settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
