package com.example.higherorlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    lateinit var textScore : TextView
    lateinit var textTime : TextView

    lateinit var buttonHigher : Button
    lateinit var buttonLower : Button

    var userScore = 0

    lateinit var timer : CountDownTimer
    private val startTimer : Short = 10000
    var timeLeft : Short = startTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)



    }
}