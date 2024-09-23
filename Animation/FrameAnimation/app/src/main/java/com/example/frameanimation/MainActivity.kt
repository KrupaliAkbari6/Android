package com.example.frameanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ad=AnimationDrawable()

        var f1=resources.getDrawable(R.drawable.frame1,null)
        var f2=resources.getDrawable(R.drawable.frame2,null)
        var f3=resources.getDrawable(R.drawable.frame3,null)
        var f4=resources.getDrawable(R.drawable.frame4,null)
        var f5=resources.getDrawable(R.drawable.frame5,null)
        var f6=resources.getDrawable(R.drawable.frame6,null)
        var f7=resources.getDrawable(R.drawable.frame7,null)

        ad.addFrame(f1,25)
        ad.addFrame(f2,25)
        ad.addFrame(f3,25)
        ad.addFrame(f4,25)
        ad.addFrame(f5,25)
        ad.addFrame(f6,25)
        ad.addFrame(f7,25)

        var imageview:ImageView=findViewById(R.id.imageView)
        imageview.background=ad
        ad.start()

    }
}