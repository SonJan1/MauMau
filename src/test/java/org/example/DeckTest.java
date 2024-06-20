package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void testDeckInitialization() {
        assertEquals(32, deck.size(), "Deck should have 32 cards after initialization");
    }

    @Test
    void testDrawCard() {
        int initialSize = deck.size();
        Card card = deck.drawCard();
        assertNotNull(card, "Drawn card should not be null");
        assertEquals(initialSize - 1, deck.size(), "Deck size should decrease by 1 after drawing a card");
    }

    @Test
    void testShuffle() {
        List<Card> cardsBeforeShuffle = new ArrayList<>(deck.cards);
        deck.shuffle();
        List<Card> cardsAfterShuffle = new ArrayList<>(deck.cards);
        assertNotEquals(cardsBeforeShuffle, cardsAfterShuffle, "Deck should be shuffled");
    }

    @Test
    void testDrawCardFromEmptyDeck() {
        while (deck.size() > 0) {
            deck.drawCard();
        }
        assertThrows(IllegalStateException.class, () -> deck.drawCard(), "Drawing from an empty deck should throw an exception");
    }
}