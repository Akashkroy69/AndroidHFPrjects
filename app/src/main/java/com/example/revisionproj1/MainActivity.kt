package com.example.revisionproj1

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var stopwatch:Chronometer
    private var running = false
    private var offset:Long = 0

//    constants
    private val OFFSET_VALUE = "offset"
    private val RUNNING_STATUS = "running"
    private val BASE = "base"

    var x: String? = null
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
        x = "in on create"
        Toast.makeText(applicationContext,x,Toast.LENGTH_SHORT).show()


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
        x = "in on start"
        Toast.makeText(applicationContext,x,Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
//        when the user returns to the activity after getting paused
        x = "in on resume"
        Toast.makeText(applicationContext,x,Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
//        when another activity comes onto the foreground
        x = "in on pause"
        Toast.makeText(applicationContext,x,Toast.LENGTH_SHORT).show()

    }
    override fun onRestart() {
        super.onRestart()
//        when the activity becomes visible again after getting invisible, (after coming from onStop)
        x = "in on restart"
        Toast.makeText(applicationContext,x,Toast.LENGTH_SHORT).show()
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
        x = "in on stop"
        Toast.makeText(applicationContext,x,Toast.LENGTH_SHORT).show()
        if(running){
            saveOffset()
            stopwatch.stop()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
//        when the activity is getting destroyed
        x = "in on destroy"
        Toast.makeText(applicationContext,x,Toast.LENGTH_SHORT).show()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong(OFFSET_VALUE,offset)
        outState.putBoolean(RUNNING_STATUS,running)
        outState.putLong(BASE,stopwatch.base)
        super.onSaveInstanceState(outState)
    }



    }
