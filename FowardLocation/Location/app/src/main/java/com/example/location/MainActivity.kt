package com.example.location

import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ActivityCompat
import java.util.*
import java.util.jar.Manifest

//Forward Location
class MainActivity : AppCompatActivity() {
    lateinit var ed:EditText
    lateinit var tv:TextView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ed=findViewById(R.id.editText)
        tv=findViewById(R.id.textView)
        btn=findViewById(R.id.button)


        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION),111)
        }
        else
        {
            btn.setOnClickListener{
                var city=ed.text.toString()
                forwardGeoLocation(city)
            }
        }

    }

    private fun forwardGeoLocation(city: String) {

        var gc=Geocoder(this, Locale.getDefault())
        var addresses=gc.getFromLocationName(city,2)
        var address=addresses.get(0)
        tv.setText("${address.longitude}\n${address.latitude}\n${address.locality}")

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 111 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            var city=ed.text.toString()
            forwardGeoLocation(city)
        }
    }
}