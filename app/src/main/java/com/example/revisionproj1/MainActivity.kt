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
    private var textValue: CharSequence? = "***"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editTextId)
        val textView:TextView = findViewById(R.id.displayTextId)
        val button:Button = findViewById(R.id.displayButtonId)

        if (savedInstanceState != null){
            textView.text = savedInstanceState.getCharSequence(TEXTKEY)
        }

        button.setOnClickListener {
            textView.text = editText.text
            textValue = textView.text
        }

        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence(TEXTKEY,textValue)
    }

    }
