package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Gondal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gondal)

        var btn: Button =findViewById(R.id.button2)
        btn.setOnClickListener {
            var i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}