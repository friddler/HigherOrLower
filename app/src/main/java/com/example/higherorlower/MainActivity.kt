package com.example.higherorlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    // Buttons on the main-screen

    lateinit var playButton : Button
    lateinit var exitButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.playButton)
        exitButton = findViewById(R.id.exitButton)






    }
}