package com.example.revisionproj1

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        adding the fragment: getting the fragment manager and fragment transactor

        val fragmentManager:FragmentManager = supportFragmentManager
        val fragmentTransactor:FragmentTransaction = fragmentManager.beginTransaction()
        val welcomeFragment2 = WelcomeFragment2()

        fragmentTransactor.add(R.id.fragmentContainer2Id,welcomeFragment2)
        fragmentTransactor.commit()

        }


}
