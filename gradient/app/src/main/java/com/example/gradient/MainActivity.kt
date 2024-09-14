package com.example.gradient

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(Test(applicationContext))
    }

    inner class Test(context :Context) : View(context) {

        var p = Paint(Paint.ANTI_ALIAS_FLAG)

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            var lg=LinearGradient(100f,100f,150f,150f,Color.BLUE,Color.RED,Shader.TileMode.MIRROR)
            p.shader=lg
            canvas?.drawOval(300f,300f,50f,50f,p)

            var rg=RadialGradient(200f,400f,100f,Color.BLUE,Color.YELLOW,Shader.TileMode.MIRROR)
            p.shader=rg
            canvas?.drawOval(500f,850f,50f,300f,p)

            var sg=SweepGradient(280f,1200f, intArrayOf(Color.BLUE,Color.YELLOW,Color.RED,Color.CYAN),null)
            p.shader=sg
            canvas?.drawOval(500f,1500f,50f,900f,p)
        }
    }
}