package com.example.database

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.contentValuesOf
import android.text.method.TextKeyListener.clear as clear1

class MainActivity : AppCompatActivity() {

    lateinit var ed_sname: EditText
    lateinit var ed_sem: EditText
    lateinit var insertBtn: Button
    lateinit var clearBtn: Button
    lateinit var updateBtn: Button
    lateinit var deleteBtn: Button
    lateinit var nextBtn: Button
    lateinit var prevBtn: Button
    lateinit var firstBtn: Button
    lateinit var lastBtn: Button
    lateinit var showBtn: Button
    lateinit var listView: ListView
    lateinit var searchView:SearchView
    lateinit var rs: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_sname = findViewById(R.id.ed_sname)
        ed_sem = findViewById(R.id.ed_sem)
        insertBtn = findViewById(R.id.insertbtn)
        clearBtn = findViewById(R.id.clearbtn)
        updateBtn = findViewById(R.id.updatebtn)
        deleteBtn = findViewById(R.id.deletebtn)
        nextBtn = findViewById(R.id.nextbtn)
        prevBtn = findViewById(R.id.previousbtn)
        firstBtn = findViewById(R.id.firstbtn)
        lastBtn = findViewById(R.id.lastbtn)
        showBtn = findViewById(R.id.showBtn)
        listView = findViewById(R.id.listView)
        searchView = findViewById(R.id.searchView)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase

        Toast.makeText(applicationContext, "DB and Table is created", Toast.LENGTH_LONG).show()
        rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT", null)
        if (rs.moveToFirst()) {
            ed_sname.setText(rs.getString(1))
            ed_sem.setText(rs.getString(2))
        }

        insertBtn.setOnClickListener {
            var cv = ContentValues()
            cv.put("SNAME", ed_sname.text.toString())
            cv.put("SEM", ed_sem.text.toString())
            db.insert("STUDENT", null, cv)
            rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT", null)
            showMessage("Record Insert Successfully")
            Clear()
        }

        clearBtn.setOnClickListener{
            Clear()
        }

        updateBtn.setOnClickListener {
            var cv = ContentValues()
            cv.put("SNAME", ed_sname.text.toString())
            cv.put("SEM", ed_sem.text.toString())
            db.update("STUDENT", cv,"SID=?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT", null)
            showMessage("Record Update Successfully")
            Clear()
        }

        deleteBtn.setOnClickListener {
            db.delete("STUDENT", "SID=?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT", null)
            showMessage("Record Delete Successfully")
            Clear()
        }

        showBtn.setOnClickListener {
            searchView.queryHint="search among ${rs.count} records"

            var adapter=SimpleCursorAdapter(applicationContext,R.layout.my_layout,rs,
                arrayOf("SNAME","SEM"),
                intArrayOf(R.id.text1,R.id.text2))
            listView.adapter=adapter

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                   return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    rs=db.rawQuery("SELECT SID _id, SNAME,SEM FROM STUDENT WHERE SNAME LIKE '%${p0}%'",null)
                    adapter.changeCursor(rs)
                   return false
                }
            })
        }




    }

    private fun Clear() {
      ed_sname.setText("")
        ed_sem.setText("")
        ed_sname.requestFocus()

    }

    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setTitle("Success!!")
            .setMessage(s)
            .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->
                if (rs.moveToFirst()) {
                    ed_sname.setText(rs.getString(1))
                    ed_sem.setText(rs.getString(2))
                } else {
                    Toast.makeText(applicationContext, "Data not Found", Toast.LENGTH_LONG).show()
                }
            }).show()
    }
}