package com.example.ca3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Print : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print)
        var printName : TextView = findViewById(R.id.printName)
        var printLang : TextView = findViewById(R.id.printLang)
        var printSex : TextView = findViewById(R.id.printSex)
        var printAge : TextView = findViewById(R.id.printAge)

        var name = intent.getStringExtra("nameVal")
        var lang1 = intent.getStringExtra("checkBoxVal1")
        var lang2 = intent.getStringExtra("checkBoxVal2")
        var sex = intent.getStringExtra("radioVal")
        var age = intent.getStringExtra("spinnerVal")

        printName.text = "Name : " + name
        printLang.text = "Language : " + lang1 + " " + lang2
        printSex.text = "Sex : Male"
        printAge.text = "Age : " + age

    }
}