package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Secondactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secondactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var cbtn: Button =findViewById(R.id.button1)
        cbtn.setOnClickListener{
            var i=Intent(this,ConstraintLayout::class.java)
            startActivity(i)
        }

        var lbtn: Button =findViewById(R.id.button2)
        lbtn.setOnClickListener{
            var j=Intent(this,LinearLayout::class.java)
            startActivity(j)
        }

        var rbtn: Button =findViewById(R.id.button3)
        rbtn.setOnClickListener{
            var k=Intent(this,RelativeLayout::class.java)
            startActivity(k)
        }

        var fbtn: Button =findViewById(R.id.button4)
        fbtn.setOnClickListener{
            var l=Intent(this,FrameLayout::class.java)
            startActivity(l)
        }


    }
}