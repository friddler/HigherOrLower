package com.example.higherorlower

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.*
import java.util.concurrent.TimeUnit


open class GameActivity : AppCompatActivity() {

    lateinit var cardImageGame : ImageView

    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTime : TextView

    lateinit var textViewGameResult : TextView

    lateinit var buttonHigher : Button
    lateinit var buttonLower : Button

    lateinit var konfettiView: KonfettiView

    var userScore = 0

    var userLife = 10

    lateinit var timer : CountDownTimer
    private val startTimer : Long = 60000 // Counts down from 60 seconds
    var timeLeft : Long = startTimer

    val cards = Deck()

    var previousCard = cards.getNewCard()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        cardImageGame = findViewById(R.id.cardImageGame)


        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textLife)
        textTime = findViewById(R.id.textTime)
        textViewGameResult = findViewById(R.id.textViewGameResult)
        konfettiView = findViewById(R.id.konfettiView)

        cardImageGame.animate().apply{
            duration = 1000
            rotationYBy(360f)
        }.start()

        cardImageGame.setImageResource(previousCard.image)

        // PROBLEM: The previousCard gets a new constant random value from 2-14 every game. PROBLEM SOLVED

        startTimer()


        buttonHigher = findViewById(R.id.buttonHigher)
        buttonHigher.setOnClickListener {
            isHigher()
        }

        buttonLower = findViewById(R.id.buttonLower)
        buttonLower.setOnClickListener {
            isLower()
        }


    }

// Function to check if the card is lower than the previous card
@SuppressLint("SetTextI18n")
fun isLower(){

        val nextCard = cards.getNewCard()

        if (nextCard.value < previousCard.value) {
            userScore += 1
            textViewGameResult.text = "You're superduper right!"
            textScore.text = userScore.toString()

            konfetti()

        } else if (nextCard.value > previousCard.value) {
            userLife--
            textViewGameResult.text = "Sorry you're wrong! It was higher :( "
            textLife.text = userLife.toString()
        } else {
            textViewGameResult.text = "The value is the same. Try again! "
            textLife.text = userLife.toString()
        }

        previousCard = nextCard
        cardImageGame.setImageResource(nextCard.image)

        gameOver()

    }

// Function to check if the card is higher than the previous card
@SuppressLint("SetTextI18n")
fun isHigher(){

        val nextCard = cards.getNewCard()

        if (nextCard.value > previousCard.value) {
            userScore += 1
            textViewGameResult.text = "You're superduper right!"
            textScore.text = userScore.toString()

            konfetti()

        } else if (nextCard.value < previousCard.value) {
            userLife--
            textViewGameResult.text = "Sorry you're wrong! It was lower :( "
            textLife.text = userLife.toString()
        } else  {
            textViewGameResult.text = "The value is the same. Try again! "
            textLife.text = userLife.toString()
        }

        previousCard = nextCard
        cardImageGame.setImageResource(nextCard.image)

        gameOver()

    }

 // If the userlife is 0 the game will go to results a display the score

 @SuppressLint("SetTextI18n")
 fun gameOver(){
        if(userLife == 0){
            textViewGameResult.text = "Game over my friend..."
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("score", userScore)
            stopTimer()
            startActivity(intent)
            finish()
        }

    }

    fun startTimer(){

        timer = object : CountDownTimer(timeLeft,1000){
            override fun onTick(millsLeft: Long) {
                timeLeft = millsLeft
                updateTextAndGameOver()
            }

            override fun onFinish() {
                stopTimer()
            }

        }.start()
    }

    fun stopTimer(){

        timer.cancel()

    }
    // Updates the timer and checks if there's no time left, it will go to ResultActivity and display the score.

    fun updateTextAndGameOver(){
        val timeRemaining : Int = (timeLeft / 1000).toInt()
        textTime.text = String.format(Locale.getDefault(),"%02d", timeRemaining)

        if(timeRemaining == 0){
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("score", userScore)
            stopTimer()
            startActivity(intent)
            finish()
        }

    }

    fun konfetti(){

        konfettiView.start(
            Party(
                angle = 10,
                speed = 0f,
                maxSpeed = 50f,
                damping = 0.9f,
                spread = 360,
                colors = listOf(0x70e000, 0x70e000, 0x70e000, 0x70e000),
                position = Position.Relative(0.5,0.3),
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100))
        )

    }

}
