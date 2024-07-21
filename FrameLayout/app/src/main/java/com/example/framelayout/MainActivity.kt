package com.example.framelayout

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var pb:ProgressBar=findViewById(R.id.progressBar)
//        pb.setProgress(50)

        Thread(Runnable {
            var count=0
            while(count<=100)
            {
                Thread.sleep(100)
                count++
                pb.setProgress(count)
                pb.secondaryProgress=count+10
                if(count>=100)
                {
                    var i =Intent(this,secondActivity::class.java)
                    startActivity(i)
                }

            }
        }).start()
    }
}