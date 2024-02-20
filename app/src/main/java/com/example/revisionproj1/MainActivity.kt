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
//        till now the activity is not visible
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
//        it is called when  the activity is about to be visible
    }

    override fun onResume() {
        super.onResume()
//        when the user returns to the activity after getting paused
    }

    override fun onPause() {
        super.onPause()
//        when another activity comes onto the foreground

    }
    override fun onRestart() {
        super.onRestart()
//        when the activity becomes visible again after getting invisible, (after coming from onStop)
        if(running){
//            running = true
            setBaseTime()
            stopwatch.start()
            offset = 0
        }
    }

    override fun onStop() {
        super.onStop()
//        when the activity is not visible
//        when the activity is not visible we need to pause the timer
        if(running){
            saveOffset()
            stopwatch.stop()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
//        when the activity is getting destroyed
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong(OFFSET_VALUE,offset)
        outState.putBoolean(RUNNING_STATUS,running)
        outState.putLong(BASE,stopwatch.base)
        super.onSaveInstanceState(outState)
    }



    }
