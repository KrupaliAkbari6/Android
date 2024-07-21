package com.example.firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RelativeLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relative_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var str:String
        var btn:Button=findViewById(R.id.button)

        btn.setOnClickListener{
            Toast.makeText(applicationContext,"Simple Button",Toast.LENGTH_LONG).show()
        }

        var imgBtn:ImageButton=findViewById(R.id.imageButton2)

        imgBtn.setOnClickListener {
            Toast.makeText(applicationContext,"Image Button",Toast.LENGTH_LONG).show()
        }

        var tbtn:ToggleButton=findViewById(R.id.toggleButton)
        var imgview:ImageView=findViewById(R.id.imageView)

        tbtn.setOnClickListener {
            if(tbtn.text.equals("OFF"))
            {
                imgview.setImageResource(R.drawable.off)
            }
            else
            {
                imgview.setImageResource(R.drawable.on)
            }
        }

        var ch1:CheckBox=findViewById(R.id.checkBox)
        var ch2:CheckBox=findViewById(R.id.checkBox2)
        var ch3:CheckBox=findViewById(R.id.checkBox3)
        var tv:TextView=findViewById(R.id.textView)

        ch1.setOnClickListener{
            str="Android:${ch1.isChecked}\nJava:${ch2.isChecked}\nKotlin:${ch3.isChecked}"
            tv.setText(str)
        }
        ch2.setOnClickListener{
            str="Android:${ch1.isChecked}\nJava:${ch2.isChecked}\nKotlin:${ch3.isChecked}"
            tv.setText(str)
        }
        ch3.setOnClickListener{
            str="Android:${ch1.isChecked}\nJava:${ch2.isChecked}\nKotlin:${ch3.isChecked}"
            tv.setText(str)
        }

        var rg:RadioGroup=findViewById(R.id.radioGroup)
        var tv1:TextView=findViewById(R.id.textView1)
        var resetbtn:Button=findViewById(R.id.button5)

        rg.setOnCheckedChangeListener { radioGroup, i ->
            var rb=findViewById<RadioButton>(i)
            if(rb!=null)
            {
                tv1.setText(rb.text)
            }
        }

        resetbtn.setOnClickListener{
            rg.clearCheck()
            tv1.setText("Select Option")
        }

        var fbtn:FloatingActionButton=findViewById(R.id.floatingActionButton2)

        fbtn.setOnClickListener{
            Toast.makeText(applicationContext,"Floating Action Button",Toast.LENGTH_LONG).show()
        }
    }
}