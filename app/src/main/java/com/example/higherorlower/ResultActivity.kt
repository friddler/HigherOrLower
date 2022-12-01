package com.example.higherorlower

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.concurrent.TimeUnit


class ResultActivity : AppCompatActivity() {

    lateinit var result : TextView

    lateinit var playAgain : Button

    lateinit var congratsText : TextView

    lateinit var messageText : TextView
    
    lateinit var exit : Button

    lateinit var konfettiView: KonfettiView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        result = findViewById(R.id.textViewResult)
        playAgain = findViewById(R.id.buttonAgain)
        exit = findViewById(R.id.buttonExit)
        konfettiView = findViewById(R.id.konfettiView)
        congratsText = findViewById(R.id.congratsText)
        messageText = findViewById(R.id.messageText)

        animationAndKonfetti()

        scoreAndMessage()



        // When the player clicks the playAgain-button it will get the results by the intent and go back to the GameActivity
        playAgain.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }


        exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()


        }
        
    }

    fun animationAndKonfetti(){

        konfettiView.start(Party(
            angle = 10,
            speed = 0f,
            maxSpeed = 50f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xFAD179, 0xDF6C8B, 0xF48188, 0xffb7ff),
            position = Position.Relative(0.5,0.3),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100))
        )


        congratsText.animate().apply{
            duration = 1000
            rotationYBy(360f)
            rotationXBy(360f)
        }.start()

    }

    fun scoreAndMessage(){

        val score = intent.getIntExtra("score", 0)
        result.text = "Your score: $score"

        if(score < 10){
            messageText.text = "You can do better than that!"
        } else if (score > 30){
            messageText.text = "Wow you're really good at this!"
        }

    }
}