package com.example.higherorlower

class deck {

    val deck = mutableListOf<Card>()

    init {
        deckOfCards()
    }

    fun deckOfCards(){

        deck.add(Card(2,R.drawable.card52))
        deck.add(Card(2,R.drawable.card51))
        deck.add(Card(2,R.drawable.card50))
        deck.add(Card(2,R.drawable.card49))
        deck.add(Card(3,R.drawable.card48))
        deck.add(Card(3,R.drawable.card47))
        deck.add(Card(3,R.drawable.card46))
        deck.add(Card(3,R.drawable.card45))
        deck.add(Card(4,R.drawable.card44))
        deck.add(Card(4,R.drawable.card43))
        deck.add(Card(4,R.drawable.card42))
        deck.add(Card(4,R.drawable.card41))
        deck.add(Card(5,R.drawable.card40))
        deck.add(Card(5,R.drawable.card39))
        deck.add(Card(5,R.drawable.card38))
        deck.add(Card(5,R.drawable.card37))
        deck.add(Card(6,R.drawable.card36))
        deck.add(Card(6,R.drawable.card35))
        deck.add(Card(6,R.drawable.card34))
        deck.add(Card(6,R.drawable.card33))
        deck.add(Card(7,R.drawable.card32))
        deck.add(Card(7,R.drawable.card31))
        deck.add(Card(7,R.drawable.card30))
        deck.add(Card(7,R.drawable.card29))
        deck.add(Card(8,R.drawable.card28))
        deck.add(Card(8,R.drawable.card27))
        deck.add(Card(8,R.drawable.card26))
        deck.add(Card(8,R.drawable.card25))
        deck.add(Card(9,R.drawable.card24))
        deck.add(Card(9,R.drawable.card23))
        deck.add(Card(9,R.drawable.card22))
        deck.add(Card(9,R.drawable.card21))
        deck.add(Card(10,R.drawable.card20))
        deck.add(Card(10,R.drawable.card19))
        deck.add(Card(10,R.drawable.card18))
        deck.add(Card(10,R.drawable.card17))
        deck.add(Card(11,R.drawable.card16))
        deck.add(Card(11,R.drawable.card15))
        deck.add(Card(11,R.drawable.card14))
        deck.add(Card(11,R.drawable.card13))
        deck.add(Card(12,R.drawable.card12))
        deck.add(Card(12,R.drawable.card11))
        deck.add(Card(12,R.drawable.card10))
        deck.add(Card(12,R.drawable.card9))
        deck.add(Card(13,R.drawable.card8))
        deck.add(Card(13,R.drawable.card7))
        deck.add(Card(13,R.drawable.card6))
        deck.add(Card(13,R.drawable.card5))
        deck.add(Card(14,R.drawable.card4))
        deck.add(Card(14,R.drawable.card3))
        deck.add(Card(14,R.drawable.card2))
        deck.add(Card(14,R.drawable.card1))

        shuffle()
    }
    fun shuffle(){
        deck.shuffle()
    }

    fun getNewCard() : Card {
        if(deck.size == 0){
            deckOfCards()
        }
        return deck.removeAt(deck.size -1)
    }

}