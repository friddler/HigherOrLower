package com.example.higherorlower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    // Buttons on the main-screen

    lateinit var playButton : Button
    lateinit var exitButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.playButton)
        exitButton = findViewById(R.id.exitButton)

        playButton.setOnClickListener {

            val intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)

        }

        exitButton.setOnClickListener {

            finish()

        }






    }
}