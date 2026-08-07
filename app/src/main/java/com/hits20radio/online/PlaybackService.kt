package com.hits20radio.online
import androidx.media3.common.*; import androidx.media3.exoplayer.ExoPlayer; import androidx.media3.session.*
class PlaybackService:MediaSessionService(){
 lateinit var player:ExoPlayer; var session:MediaSession?=null
 override fun onCreate(){super.onCreate();player=ExoPlayer.Builder(this).build().apply{setAudioAttributes(AudioAttributes.Builder().setUsage(C.USAGE_MEDIA).setContentType(C.AUDIO_CONTENT_TYPE_MUSIC).build(),true);setHandleAudioBecomingNoisy(true)};session=MediaSession.Builder(this,player).build()}
 override fun onGetSession(i:MediaSession.ControllerInfo)=session
 override fun onDestroy(){player.release();session?.release();super.onDestroy()}
}