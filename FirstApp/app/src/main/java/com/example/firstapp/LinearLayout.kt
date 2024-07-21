package com.example.firstapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LinearLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_linear_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var edemail: EditText = findViewById(R.id.editemail)
        edemail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(p0).matches()) {
                    edemail.setError("Invalid Input")
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        var actvCity: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)

        var city = arrayOf("Rajkot", "Gondal", "Surat", "Ahmedabad", "Gandhinagar", "Jamnagar")
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, city)
        actvCity.setAdapter(adapter)

        var mactvSkill: MultiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView)

        var skills = arrayOf(
            "Html",
            "css",
            "android",
            "Php",
            "Laravel",
            "Python",
            "Java",
            "Asp.net",
            "ML",
            "Node"
        )
        var skilladapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, skills)
        mactvSkill.setAdapter(skilladapter)
        mactvSkill.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

    }
}