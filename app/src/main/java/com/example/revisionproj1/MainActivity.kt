package com.example.revisionproj1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        adding the MaterialToolbar as app bar
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarId)
        setSupportActionBar(toolbar)

        }


}