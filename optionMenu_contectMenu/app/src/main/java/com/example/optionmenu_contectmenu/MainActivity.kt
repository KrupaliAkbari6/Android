package com.example.optionmenu_contectmenu

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var tv1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1=findViewById(R.id.textview)
        registerForContextMenu(tv1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menu?.add(101,1001,1,"New Group")
        menu?.add(102,1002,2,"New BroadCast")
        menu?.add(103,1003,3,"Linked Device")
        menu?.add(104,1004,4,"Payment")
        menu?.add(105,1005,5,"Setting")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            1001->Toast.makeText(applicationContext,"New Group Clicked!!",Toast.LENGTH_LONG).show()
            1002->Toast.makeText(applicationContext,"New BroadCast Clicked!!",Toast.LENGTH_LONG).show()
            1003->tv1.textSize=40f
            1004->tv1.setText("Krupali Akbari")
            1005->{
                var i = Intent(this,SettingActivity::class.java)
                startActivity(i)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menu?.setHeaderTitle("Choose Color")
        menu?.add(101,1111,1,"RED")
        menu?.add(102,1112,2,"GREEN")
        menu?.add(103,1113,3,"BLUE")
        menu?.add(104,1114,4,"BLACK")
        menu?.add(105,1115,5,"MAGENTA")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            1111->tv1.setTextColor(Color.RED)
            1112->tv1.setTextColor(Color.GREEN)
            1113->tv1.setTextColor(Color.BLUE)
            1114->tv1.setTextColor(Color.BLACK)
            1115->tv1.setTextColor(Color.MAGENTA)
        }

        return super.onContextItemSelected(item)
    }
}