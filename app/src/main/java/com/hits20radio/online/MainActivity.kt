package com.hits20radio.online

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.hits20radio.online.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del diseño XML en español
        val playBtn = findViewById<Button>(R.id.play)
        val statusText = findViewById<TextView>(R.id.status)
        val videoBtn = findViewById<Button>(R.id.videoBtn)
        val settingsBtn = findViewById<Button>(R.id.settings)

        // Configurar botón de reproducción en español
        playBtn.setOnClickListener {
            statusText.text = "TRANSMITIENDO EN VIVO..."
            playBtn.text = "⏸ PAUSAR HITS20"
        }

        // Configuración del botón de video
        videoBtn.setOnClickListener {
            // Aquí puedes abrir la sección de video o transmisión en vivo
        }

        // Botón para abrir la configuración en español
        settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
