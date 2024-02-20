package com.example.revisionproj1

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var stopwatch:Chronometer
    private var running = false
    private var offset:Long = 0

//    constants
    private val OFFSET_VALUE = "offset"
    private val RUNNING_STATUS = "running"
    private val BASE = "base"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stopwatch = findViewById<Chronometer>(R.id.chronometer)

        if(savedInstanceState != null){
            offset = savedInstanceState.getLong(OFFSET_VALUE)
            running = savedInstanceState.getBoolean(RUNNING_STATUS)
            if (running){
                stopwatch.base = savedInstanceState.getLong(BASE)
                stopwatch.start()
            }else{
                setBaseTime()
            }
        }

        val startButton = findViewById<Button>(R.id.start)
        val pauseButton = findViewById<Button>(R.id.pause)
        val resetButton = findViewById<Button>(R.id.reset)

        startButton.setOnClickListener {
            if(!running) {
                running = true
                setBaseTime()
                stopwatch.start()
            }

        }

        pauseButton.setOnClickListener {
            if(running){
                saveOffset()
                running = false
                stopwatch.stop()

            }

        }

        resetButton.setOnClickListener {
            offset = 0
            stopwatch.base = SystemClock.elapsedRealtime()-offset

        }

        }

     private fun setBaseTime(){
         stopwatch.base = SystemClock.elapsedRealtime() - offset
     }

    private fun saveOffset(){
        offset = SystemClock.elapsedRealtime() - stopwatch.base
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
    override fun onRestart() {
        super.onRestart()
    }

    override fun onStop() {
        super.onStop()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong(OFFSET_VALUE,offset)
        outState.putBoolean(RUNNING_STATUS,running)
        outState.putLong(BASE,stopwatch.base)
        super.onSaveInstanceState(outState)
    }



    }
