package com.example.assigment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var sendbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button)
        sendbtn=findViewById(R.id.button)
        var sms="Your Note Has Been Saved"
        button.setOnClickListener{
            saveActivity()
            NotificationHelper(this,sms)
            Toast.makeText(this,"${sms} is saved ",Toast.LENGTH_LONG).show()
        }

    }

    private fun saveActivity()
    {
        val txt=findViewById<MultiAutoCompleteTextView>(R.id.texter)
        val msg=txt.text.toString()
        val saved= Intent(
            this,
            saveActivity()::class.java
        ).also {
            it.putExtra("saved message",msg)
           startActivity(it)
        }

    }

}




