package com.example.higherorlower


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random


class GameActivity : AppCompatActivity() {

    private lateinit var cardHidden: ImageView
    lateinit var cardVisible : ImageView

    lateinit var textScore : TextView
    lateinit var textTime : TextView

    lateinit var buttonHigher : Button
    lateinit var buttonLower : Button
    lateinit var buttonTurn : Button


    var userScore = 0


    lateinit var timer : CountDownTimer
    private val startTimer : Short = 10000
    var timeLeft : Short = startTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        cardHidden = findViewById(R.id.cardHidden)
        cardHidden.setImageResource(R.drawable.hiddencard)

        cardVisible = findViewById(R.id.cardVisible)


        textScore = findViewById(R.id.textViewScore)
        textTime = findViewById(R.id.textViewTime)

        buttonHigher = findViewById(R.id.buttonHigher)
        buttonLower = findViewById(R.id.buttonLower)
        buttonTurn = findViewById(R.id.buttonTurn)


        val cardList = mutableListOf (
            R.drawable.card1, R.drawable.card2,
            R.drawable.card3, R.drawable.card4,
            R.drawable.card5, R.drawable.card6,
            R.drawable.card7, R.drawable.card8,
            R.drawable.card9, R.drawable.card10,
            R.drawable.card11, R.drawable.card12,
            R.drawable.card13, R.drawable.card14,
            R.drawable.card15, R.drawable.card16,
            R.drawable.card17, R.drawable.card18,
            R.drawable.card19, R.drawable.card20,
            R.drawable.card21, R.drawable.card22,
            R.drawable.card23, R.drawable.card24,
            R.drawable.card25, R.drawable.card26,
            R.drawable.card27, R.drawable.card28,
            R.drawable.card29, R.drawable.card30,
            R.drawable.card31, R.drawable.card32,
            R.drawable.card33, R.drawable.card34,
            R.drawable.card35, R.drawable.card36,
            R.drawable.card37, R.drawable.card38,
            R.drawable.card39, R.drawable.card40,
            R.drawable.card41, R.drawable.card42,
            R.drawable.card43, R.drawable.card44,
            R.drawable.card45, R.drawable.card46,
            R.drawable.card47, R.drawable.card48,
            R.drawable.card49, R.drawable.card50,
            R.drawable.card51, R.drawable.card52
        )


        buttonLower.setOnClickListener {
            val random = Random
            cardHidden.setImageResource(cardList[random.nextInt(cardList.size)])
            cardVisible.setImageResource(cardList[random.nextInt(cardList.size)])



        }

        buttonHigher.setOnClickListener {
            val random = Random
            cardHidden.setImageResource(cardList[random.nextInt(cardList.size)])
            cardVisible.setImageResource(cardList[random.nextInt(cardList.size)])


        }


    }
    fun deckOfCards(value : Int, image : Int){




    }


}










