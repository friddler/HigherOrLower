package com.example.higherorlower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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

    var userScore = 0

    var userLife = 10


    lateinit var timer : CountDownTimer
    private val startTimer : Long = 60000
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

        cardImageGame.setOnClickListener {
            cardImageGame.animate().apply{
                duration = 1000
                rotationYBy(360f)
            }.start()
        }

        cardImageGame.setImageResource(previousCard.image)

        // PROBLEM: The currentCard gets a new constant random value from 2-14 every game. PROBLEM SOLVED

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


    fun isLower(){

        val nextCard = cards.getNewCard()

        if (nextCard.value < previousCard.value) {
            userScore = userScore + 1
            textViewGameResult.text = "You're superduper right!"
            textScore.text = userScore.toString()

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


    fun isHigher(){

        val nextCard = cards.getNewCard()

        if (nextCard.value > previousCard.value) {
            userScore = userScore + 1
            textViewGameResult.text = "You're superduper right!"
            textScore.text = userScore.toString()

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

    fun gameOver(){
        if(userLife == 0){
            textViewGameResult.text = "Game over my friend..."
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("score", userScore)
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
                updateTextAndGameOver()
                textViewGameResult.text = "Time is up! You lost!"


            }

        }.start()
    }



    fun updateTextAndGameOver(){
        val timeRemaining : Int = (timeLeft / 1000).toInt()
        textTime.text = String.format(Locale.getDefault(),"%02d", timeRemaining)

        if(timeRemaining == 0){
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
            finish()
        }



    }


}
































/*
islower
val nextCard = Deck.getNewCard()
        val currentCard = Deck.getNewCard()
        if (nextCard.value < currentCard.value) {
            userScore = userScore + 1
            textViewGameResult.text = "You're superduper right!"
            textScore.text = userScore.toString()
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)
        } else if (nextCard.value > currentCard.value){
            textViewGameResult.text = "Sorry you're wrong! It was higher :( "
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)
        } else if (nextCard.value == currentCard.value) {
            textViewGameResult.text = "The value is the same. Try again! "
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)
        }
isHigher
        val nextCard = Deck.getNewCard()
        val currentCard = Deck.getNewCard()
        if (nextCard.value > currentCard.value) {
            userScore = userScore + 1
            textViewGameResult.text = "You're superduper right!"
            textScore.text = userScore.toString()
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)
        } else if (nextCard.value < currentCard.value){
            textViewGameResult.text = "Sorry you're wrong! It was lower :( "
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)
        } else if (nextCard.value == currentCard.value) {
            textViewGameResult.text = "The value is the same. Try again! "
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)
        }
 */
/*
            val intent = Intent(this@GameActivity,Deck::class.java)
            intent.putExtra("card", 2-14)
            startActivity(intent)
            if(currentCard < nextCard){
                userScore = userScore + 1
                textViewGameResult.text = "You're superduper right!"
                textScore.text = userScore.toString()
            } else {
                textViewGameResult.text = "Sorry you were wrong :( "
                val card = Deck.getNewCard()
                visibleCard.setImageResource(card.image)
            }
 */











