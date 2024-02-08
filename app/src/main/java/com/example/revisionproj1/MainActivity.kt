package com.example.revisionproj1

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var stopwatch:Chronometer
    var running = false
    var offset:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stopwatch = findViewById<Chronometer>(R.id.chronometer)

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

     fun setBaseTime(){
         stopwatch.base = SystemClock.elapsedRealtime() - offset
     }

    fun saveOffset(){
        offset = SystemClock.elapsedRealtime() - stopwatch.base
    }

  



    }
