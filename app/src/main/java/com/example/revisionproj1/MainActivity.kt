package com.example.revisionproj1

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ids of views
        val findBeerButton = findViewById<Button>(R.id.okButtonId)
        val beerText = findViewById<TextView>(R.id.beerTypeTextId)
        val spinner = findViewById<Spinner>(R.id.spinnerId)
        val inputArea = findViewById<EditText>(R.id.inputTextId)
        findBeerButton.setOnClickListener {
//          val beer = spinner.selectedItem.toString() or following will work
            val beer = "${spinner.selectedItem}"
            beerText.text = beer
//            in the input area string is not allowed, but the editable  is allowed
            inputArea.text = Editable.Factory.getInstance().newEditable(beer)

        }


    }
}