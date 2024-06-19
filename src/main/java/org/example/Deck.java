package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    final List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck(){
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                cards.add(new Card(rank,suit));
            }
        }
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int size(){
        return cards.size();
    }

    public Card drawCard(){
        if (cards.isEmpty()){
            throw new IllegalStateException("The deck is empty");
        }
        return cards.remove(cards.size() -1);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
