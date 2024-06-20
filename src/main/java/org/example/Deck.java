package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The {@code Deck} class represents a collection of playing cards.
 * It provides methods to initialize, shuffle, manipulate, and interact with the deck.
 */
public class Deck {
    final List<Card> cards;

    /**
     * Constructs a new deck of cards by initializing it with all possible combinations of suits and ranks,
     * and then shuffles the deck.
     */
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    /**
     * Shuffles the cards in the deck using {@link Collections#shuffle(List)} method.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Returns the current number of cards in the deck.
     *
     * @return the number of cards in the deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * Draws (removes and returns) the top card from the deck.
     *
     * @return the top card from the deck
     * @throws IllegalStateException if the deck is empty
     */
    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("The deck is empty");
        }
        return cards.remove(cards.size() - 1);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
