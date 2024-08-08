package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list:ListView=findViewById(R.id.ListView)
        var city= arrayListOf("Rajkot","Gondal","Surat","Gandhinagar")
        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city)
        list.adapter=adapter

        list.setOnItemClickListener { adapterView, view, i, l ->
            var value=list.getItemAtPosition(i).toString()
            Toast.makeText(applicationContext,value,Toast.LENGTH_LONG).show()

            if(i==0)
            {
                var i=Intent(this,Rajkot::class.java)
                startActivity(i)
            }
            if(i==1)
            {
                var i=Intent(this,Gondal::class.java)
                startActivity(i)
            }
            if(i==2)
            {
                var i=Intent(this,Surat::class.java)
                startActivity(i)
            }
            if(i==3)
            {
                var i=Intent(this,Gandhinagar::class.java)
                startActivity(i)
            }

        }
    }
}