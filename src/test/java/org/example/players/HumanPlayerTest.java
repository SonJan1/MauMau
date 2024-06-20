package org.example.players;

import org.example.Card;
import org.example.Rank;
import org.example.Suit;
import org.example.interfaces.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HumanPlayerTest {
    private HumanPlayer humanPlayer;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        humanPlayer = new HumanPlayer("Alice");
        mockGame = mock(Game.class);
    }

    @Test
    void testTakeTurn_DrawCard() {
        List<Card> initialHand = Arrays.asList(
                new Card(Rank.SEVEN, Suit.DIAMONDS),
                new Card(Rank.EIGHT, Suit.HEARTS),
                new Card(Rank.JACK, Suit.CLUBS)
        );
        humanPlayer.addCardToHand(initialHand.get(0));
        humanPlayer.addCardToHand(initialHand.get(1));
        humanPlayer.addCardToHand(initialHand.get(2));

        String input = "-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        humanPlayer.takeTurn(mockGame);

        verify(mockGame).drawCard();
        assertEquals(4, humanPlayer.getHand().size());
    }

    @Test
    void testTakeTurn_PlayCard() {
        List<Card> initialHand = Arrays.asList(
                new Card(Rank.SEVEN, Suit.DIAMONDS),
                new Card(Rank.EIGHT, Suit.HEARTS),
                new Card(Rank.JACK, Suit.CLUBS)
        );
        humanPlayer.addCardToHand(initialHand.get(0));
        humanPlayer.addCardToHand(initialHand.get(1));
        humanPlayer.addCardToHand(initialHand.get(2));

        String input = "0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        when(mockGame.getTopCard()).thenReturn(new Card(Rank.SEVEN, Suit.HEARTS));

        humanPlayer.takeTurn(mockGame);

        verify(mockGame).setTopCard(any(Card.class));
        assertEquals(2, humanPlayer.getHand().size());
    }

    @Test
    void testHasWon() {
        assertTrue(humanPlayer.hasWon());

        humanPlayer.addCardToHand(new Card(Rank.SEVEN, Suit.DIAMONDS));
        assertFalse(humanPlayer.hasWon());
    }

    @Test
    void testGetScore() {
        humanPlayer.addCardToHand(new Card(Rank.SEVEN, Suit.DIAMONDS));
        humanPlayer.addCardToHand(new Card(Rank.EIGHT, Suit.HEARTS));
        humanPlayer.addCardToHand(new Card(Rank.JACK, Suit.CLUBS));

        assertEquals(25, humanPlayer.getScore());
    }
}