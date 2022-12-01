package com.example.higherorlower


class Deck {


    val deckOfCards = mutableListOf<Card>()


    init {
        createDeck()
    }

     fun createDeck(){

        deckOfCards.add(Card(2,R.drawable.card52))
        deckOfCards.add(Card(2,R.drawable.card51))
        deckOfCards.add(Card(2,R.drawable.card50))
        deckOfCards.add(Card(2,R.drawable.card49))
        deckOfCards.add(Card(3,R.drawable.card48))
        deckOfCards.add(Card(3,R.drawable.card47))
        deckOfCards.add(Card(3,R.drawable.card46))
        deckOfCards.add(Card(3,R.drawable.card45))
        deckOfCards.add(Card(4,R.drawable.card44))
        deckOfCards.add(Card(4,R.drawable.card43))
        deckOfCards.add(Card(4,R.drawable.card42))
        deckOfCards.add(Card(4,R.drawable.card41))
        deckOfCards.add(Card(5,R.drawable.card40))
        deckOfCards.add(Card(5,R.drawable.card39))
        deckOfCards.add(Card(5,R.drawable.card38))
        deckOfCards.add(Card(5,R.drawable.card37))
        deckOfCards.add(Card(6,R.drawable.card36))
        deckOfCards.add(Card(6,R.drawable.card35))
        deckOfCards.add(Card(6,R.drawable.card34))
        deckOfCards.add(Card(6,R.drawable.card33))
        deckOfCards.add(Card(7,R.drawable.card32))
        deckOfCards.add(Card(7,R.drawable.card31))
        deckOfCards.add(Card(7,R.drawable.card30))
        deckOfCards.add(Card(7,R.drawable.card29))
        deckOfCards.add(Card(8,R.drawable.card28))
        deckOfCards.add(Card(8,R.drawable.card27))
        deckOfCards.add(Card(8,R.drawable.card26))
        deckOfCards.add(Card(8,R.drawable.card25))
        deckOfCards.add(Card(9,R.drawable.card24))
        deckOfCards.add(Card(9,R.drawable.card23))
        deckOfCards.add(Card(9,R.drawable.card22))
        deckOfCards.add(Card(9,R.drawable.card21))
        deckOfCards.add(Card(10,R.drawable.card20))
        deckOfCards.add(Card(10,R.drawable.card19))
        deckOfCards.add(Card(10,R.drawable.card18))
        deckOfCards.add(Card(10,R.drawable.card17))
        deckOfCards.add(Card(11,R.drawable.card16))
        deckOfCards.add(Card(11,R.drawable.card15))
        deckOfCards.add(Card(11,R.drawable.card14))
        deckOfCards.add(Card(11,R.drawable.card13))
        deckOfCards.add(Card(12,R.drawable.card12))
        deckOfCards.add(Card(12,R.drawable.card11))
        deckOfCards.add(Card(12,R.drawable.card10))
        deckOfCards.add(Card(12,R.drawable.card9))
        deckOfCards.add(Card(13,R.drawable.card8))
        deckOfCards.add(Card(13,R.drawable.card7))
        deckOfCards.add(Card(13,R.drawable.card6))
        deckOfCards.add(Card(13,R.drawable.card5))
        deckOfCards.add(Card(14,R.drawable.card4))
        deckOfCards.add(Card(14,R.drawable.card3))
        deckOfCards.add(Card(14,R.drawable.card2))
        deckOfCards.add(Card(14,R.drawable.card1))

         shuffle()

    }
    fun shuffle(){
        deckOfCards.shuffle()
    }



    fun getNewCard() : Card {
        if(deckOfCards.size == 0){
            createDeck()
        }
        return deckOfCards.removeAt(deckOfCards.size -1)
    }

}