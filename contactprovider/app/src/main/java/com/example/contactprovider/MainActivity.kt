//package com.example.contactprovider
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.database.Cursor
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.PersistableBundle
//import android.provider.ContactsContract
//import android.widget.ListView
//import android.widget.SearchView
//import android.widget.SimpleCursorAdapter
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import java.util.jar.Manifest
//
//class MainActivity : AppCompatActivity() {
//    lateinit var rs : Cursor
//    lateinit var adapter : SimpleCursorAdapter
//    var cols = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone._ID)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),11)
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),12)
//
//        }else{
//            readContacts()
//        }
//
//    }
//
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 11 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            readContacts()
//        }
//        else if (requestCode == 12 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            readContacts()
//        }
//
//        val searchView: SearchView = findViewById(R.id.searchView)
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                filterContacts(query)
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                filterContacts(newText)
//                return true
//            }
//        })
//    }
//
//    @SuppressLint("Range")
//    private fun readContacts() {
//
//        rs = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,cols,null,null,null)!!
//        if(rs!=null) {
//            var adapter = SimpleCursorAdapter(
//                applicationContext, android.R.layout.simple_expandable_list_item_2, rs, cols,
//                intArrayOf(android.R.id.text1, android.R.id.text2)
//            )
//            var listView: ListView = findViewById(R.id.list_item)
//            listView.adapter = adapter
//
//            listView.setOnItemClickListener { adapterView, view, i, l ->
//                rs.moveToPosition(i)
//                val phoneNumber = rs.getString(i)
//
//                // Check if call permission is granted
//                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
//                    != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this,
//                        arrayOf(android.Manifest.permission.CALL_PHONE),
//                        12)
//                } else {
//                    // Make the phone call
//                    makePhoneCall(phoneNumber)
//                }
//            }
//
//        }
//        else{}
//    }
//
//    private fun makePhoneCall(phoneNumber: String?) {
//        if (!phoneNumber.isNullOrEmpty()) {
//            val i = Intent(Intent.ACTION_CALL).apply {
//                data = Uri.parse("tel:$phoneNumber")
//            }
//            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                startActivity(i)
//            } else {
//                // Handle permission not granted scenario
//                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 12)
//            }
//        }
//    }
//
//    private fun filterContacts(query: String?) {
//        val selection = if (query.isNullOrEmpty()) null else "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?"
//        val selectionArgs = if (query.isNullOrEmpty()) null else arrayOf("%$query%")
//        rs = contentResolver.query(
//            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//            arrayOf(
//                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.NUMBER,
//                ContactsContract.CommonDataKinds.Phone._ID
//            ),
//            selection,
//            selectionArgs,
//            null
//        )!!
//
//        adapter.changeCursor(rs)
//    }
//
//}



package com.example.contactprovider

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {



     lateinit var cursor: Cursor
     lateinit var adapter: SimpleCursorAdapter
     lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_item)

        // Request permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
//            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE), 1)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),1)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),2)
        }
        else
        {
            readContacts()
        }

        var fl:FloatingActionButton=findViewById(R.id.floatingActionButton6)
        fl.setOnClickListener{
            var i=Intent(Intent.ACTION_INSERT).apply {
                type=ContactsContract.RawContacts.CONTENT_TYPE
            }
            startActivityForResult(i,1)
        }

        val searchView: SearchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterContacts(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterContacts(newText)
                return true
            }
        })
    }

    @SuppressLint("Range")
    private fun readContacts() {
        val cols = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID
        )

        cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, cols, null, null, null)!!
        adapter = SimpleCursorAdapter(
            this,
            android.R.layout.simple_expandable_list_item_2,
            cursor,
            cols,
            intArrayOf(android.R.id.text1, android.R.id.text2),
            0
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            cursor.moveToPosition(position)
            val phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            makeCall(phoneNumber)
        }
    }

    private fun filterContacts(query: String?) {
        val selection = if (query.isNullOrEmpty()) null else "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?"
        val selectionArgs = if (query.isNullOrEmpty()) null else arrayOf("%$query%")
        cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID
            ),
            selection,
            selectionArgs,
            null
        )!!
        adapter.changeCursor(cursor)
    }

    private fun makeCall(phoneNumber: String?) {
        if (!phoneNumber.isNullOrEmpty()) {
            val callIntent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(callIntent)
            } else {
                // Handle permission not granted scenario
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 2
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                readContacts()
            } else {
                // Permissions denied
            }
        }
    }
}

