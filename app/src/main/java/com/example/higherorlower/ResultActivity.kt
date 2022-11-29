package com.example.higherorlower

import android.content.Intent
import android.graphics.PostProcessor
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.core.models.Size
import nl.dionsegijn.konfetti.core.models.Size.Companion.MEDIUM
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess


class ResultActivity : AppCompatActivity() {

    lateinit var result : TextView

    lateinit var playAgain : Button

    lateinit var textView4 : TextView
    
    lateinit var exit : Button

    lateinit var konfettiView: KonfettiView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        result = findViewById(R.id.textViewResult)
        playAgain = findViewById(R.id.buttonAgain)
        exit = findViewById(R.id.buttonExit)
        konfettiView = findViewById(R.id.konfettiView)
        textView4 = findViewById(R.id.textView4)

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

        textView4.setOnClickListener {
            textView4.animate().apply{
                duration = 1000
                rotationYBy(360f)
                rotationXBy(360f)
            }.start()
        }



        val score = intent.getIntExtra("score", 0)
        result.text = "Your score: " + score

        // When the player clicks the playAgain-button it will get the results by the intent and go back to the GameActivity
        playAgain.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }


        exit.setOnClickListener {


        }
        
    }
}