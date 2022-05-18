package com.example.assigment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class savednote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savednote)

        val msg=intent.getStringExtra("saved message")
        val textView=findViewById<TextView>(R.id.textView).apply { text=msg }
    }
}