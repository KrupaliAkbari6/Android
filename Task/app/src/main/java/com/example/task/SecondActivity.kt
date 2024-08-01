package com.example.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var rb:Button=findViewById(R.id.RegisterButton)
        rb.setOnClickListener {
            var i= Intent(this,RegisterForm::class.java)
            startActivity(i)
        }

        var unm:EditText=findViewById(R.id.editUsername)
        var pass:EditText=findViewById(R.id.editPassword)
    }
}