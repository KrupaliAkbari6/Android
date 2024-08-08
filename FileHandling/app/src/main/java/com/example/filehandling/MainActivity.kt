 package com.example.filehandling

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text : EditText = findViewById(R.id.multitext)
        var btn_write : Button = findViewById(R.id.button)
        var btn_read  : Button = findViewById(R.id.button2)
        var builder = AlertDialog.Builder(this)

        btn_write.setOnClickListener {
            var fop = openFileOutput("MyFile",Context.MODE_PRIVATE)
            fop.write(text.text.toString().toByteArray())
            builder.setTitle("File Handling")
            builder.setMessage("Data Saved")
            builder.setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.setNegativeButton("CANCEL",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.setNeutralButton("CLOSE",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()
            text.setText("")
        }

        btn_read.setOnClickListener {
            var fip = application.openFileInput("MyFile")
            var br = BufferedReader(InputStreamReader(fip))
            var line :String? = ""
            while (line != null)
            {
                line = br.readLine()
                if(line != null)
                {

                    builder.setTitle("File Handling")
                    builder.setMessage("Data Read")
                    builder.setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    builder.setNegativeButton("CANCEL",DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    builder.setNeutralButton("CLOSE",DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    builder.show()
                    text.append((line + "\n"))
                }
            }
        }
    }
}