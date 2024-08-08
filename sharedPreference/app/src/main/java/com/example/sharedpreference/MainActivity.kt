package com.example.sharedpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var s_btn:Button=findViewById(R.id.SaveButton)
        var unm:EditText=findViewById(R.id.EdUsername)
        var pass:EditText=findViewById(R.id.EdPassword)


        var sp=application.getSharedPreferences("LoginData",Context.MODE_PRIVATE)
        var editor=sp.edit()

        s_btn.setOnClickListener{
            editor.putString("username",unm.text.toString())
            editor.putString("password",pass.text.toString())
            editor.commit()

            Toast.makeText(applicationContext,"DataSaved",Toast.LENGTH_LONG).show()
                unm.setText("")
                pass.setText("")
        }

        var v_btn:Button=findViewById(R.id.ViewButton)
        var textview1:TextView=findViewById(R.id.textview1)
        var textview2:TextView=findViewById(R.id.textview2)
        v_btn.setOnClickListener {
            textview1.setText(sp.getString("username",""))
            textview2.setText(sp.getString("password",""))
        }
    }
}