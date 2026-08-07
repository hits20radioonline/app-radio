package com.hits20radio.online
import android.content.Context
import android.graphics.*; import android.media.audiofx.Visualizer; import android.util.AttributeSet; import android.view.View; import kotlin.math.abs
class AudioSpectrumView(c:Context,a:AttributeSet?=null):View(c,a){
 private val p=Paint(1).apply{color=0xff55eaff.toInt();strokeWidth=6f;strokeCap=Paint.Cap.ROUND}
 private var v:Visualizer?=null; private var data=ByteArray(128)
 fun start(){if(v!=null)return; try{v=Visualizer(0).apply{captureSize=Visualizer.getCaptureSizeRange()[1];setDataCaptureListener(object:Visualizer.OnDataCaptureListener{
 override fun onWaveFormDataCapture(x:Visualizer?,d:ByteArray?,r:Int){if(d!=null){data=d.copyOf();postInvalidate()}}
 override fun onFftDataCapture(x:Visualizer?,d:ByteArray?,r:Int){}
},Visualizer.getMaxCaptureRate(),true,false);enabled=true}}catch(_:Exception){}}
 fun stop(){v?.release();v=null;invalidate()}
 override fun onDraw(c:Canvas){super.onDraw(c);val n=32;val gap=width.toFloat()/(n+1);val base=height*.55f
 for(i in 0 until n){val x=gap*(i+1);val d=data[(i*data.size/n).coerceAtMost(data.lastIndex)].toInt();val h=height*.4f*(abs(d-128)/128f).coerceAtLeast(.04f);c.drawLine(x,base-h,x,base+h*.25f,p)};if(v!=null)postInvalidateDelayed(45)}
}