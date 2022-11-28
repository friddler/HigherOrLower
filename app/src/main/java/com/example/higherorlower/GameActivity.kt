package com.example.higherorlower



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView



class GameActivity : AppCompatActivity() {

    lateinit var visibleCard: ImageView

    lateinit var textScore : TextView
    lateinit var textTime : TextView
    lateinit var textViewGameResult : TextView

    lateinit var buttonHigher : Button
    lateinit var buttonLower : Button

    var userScore = 0


/*
    lateinit var timer : CountDownTimer
    private val startTimer : Short = 10000
    var timeLeft : Short = startTimer

 */
    val Deck = deck()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        visibleCard = findViewById(R.id.visibleCard)


        textScore = findViewById(R.id.textViewScore)
        textTime = findViewById(R.id.textViewTime)
        textViewGameResult = findViewById(R.id.textViewGameResult)

        buttonHigher = findViewById(R.id.buttonHigher)
        buttonLower = findViewById(R.id.buttonLower)


        val currentCard = Deck.getNewCard()
        visibleCard.setImageResource(currentCard.image)


        buttonHigher.setOnClickListener {
            isHigher()


        }

        buttonLower.setOnClickListener {
            isLower()

        }



    }


    private fun isLower() {


        val nextCard = Deck.getNewCard()
        val currentCard = Deck.getNewCard()

        if (nextCard.value == currentCard.value) {
            textViewGameResult.text = "The value is the same. Try again! "
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)

        } else if (nextCard.value < currentCard.value){
            userScore = userScore + 1
            textViewGameResult.text = "You're superduper right!"
            textScore.text = userScore.toString()
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)

        } else if (nextCard.value > currentCard.value) {
            textViewGameResult.text = "Sorry you're wrong! It was higher :( "
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)

        }

        Log.d("!!!",currentCard.value.toString())
        Log.d("!!!",nextCard.value.toString())


    }
    private fun isHigher(){

        val nextCard = Deck.getNewCard()
        val currentCard = Deck.getNewCard()

        if (nextCard.value == currentCard.value) {
            textViewGameResult.text = "The value is the same. Try again! "
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)

        } else if (nextCard.value > currentCard.value){
            userScore = userScore + 1
            textViewGameResult.text = "You're superduper right!"
            textScore.text = userScore.toString()
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)

        } else if (nextCard.value < currentCard.value) {
            textViewGameResult.text = "Sorry you're wrong! It was lower :( "
            Deck.getNewCard()
            visibleCard.setImageResource(nextCard.image)


        }
        Log.d("???",currentCard.value.toString())


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









