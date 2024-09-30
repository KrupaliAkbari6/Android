package com.example.audioplayer

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var audiooffline : Button
    lateinit var stopoff : Button
    lateinit var audioonline : Button
    lateinit var stopon : Button
    lateinit var mp:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audiooffline=findViewById(R.id.Audiooffline)
        stopoff=findViewById(R.id.stopoffline)
        audioonline=findViewById(R.id.Audioonline)
        stopon=findViewById(R.id.stoponline)

        audiooffline.setOnClickListener{
            mp = MediaPlayer.create(this,R.raw.audio)
            mp.start()
        }
        stopoff.setOnClickListener {
            mp.stop()
        }

        audioonline.setOnClickListener {
            mp = MediaPlayer()
            mp.setDataSource(this, Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"))
            mp?.prepareAsync()
            mp.start()
        }
        stopon.setOnClickListener {
            mp.stop()
        }



    }
}