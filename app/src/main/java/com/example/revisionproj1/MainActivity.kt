package com.example.revisionproj1

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TEXTKEY = "text"
    private val editText: EditText = findViewById(R.id.editTextId)
    private val textView:TextView = findViewById(R.id.displayTextId)
    private val button:Button = findViewById<Button>(R.id.displayButtonId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            textView.text = savedInstanceState.getString(TEXTKEY)
        }

        button.setOnClickListener {
            textView.text = editText.text
        }

        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXTKEY,textView.text.toString())
    }







    }
