package com.hits20radio.online
import com.hits20radio.online.R import android.os.Bundle; import androidx.activity.ComponentActivity; import androidx.media3.common.MediaItem; import androidx.media3.exoplayer.ExoPlayer; import androidx.media3.ui.PlayerView
class VideoActivity:ComponentActivity(){companion object{const val URL="https://stream.radiosmundiales.com/hls/sanluismas/sanluismas.m3u8"};var p:ExoPlayer?=null
override fun onCreate(b:Bundle?){super.onCreate(b);setContentView(R.layout.activity_video);val v=findViewById<PlayerView>(R.id.playerView);findViewById<android.widget.Button>(R.id.back).setOnClickListener{finish()};p=ExoPlayer.Builder(this).build().also{v.player=it;it.setMediaItem(MediaItem.fromUri(URL));it.prepare();it.play()}}
override fun onStop(){p?.release();p=null;super.onStop()}}
