package org.example.players;

import org.example.Card;
import org.example.Rank;
import org.example.Suit;
import org.example.interfaces.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComputerPlayerTest {
    private ComputerPlayer computerPlayer;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        computerPlayer = new ComputerPlayer("Computer");
        mockGame = mock(Game.class);
        computerPlayer.addCardToHand(new Card(Rank.SEVEN, Suit.DIAMONDS));
        computerPlayer.addCardToHand(new Card(Rank.EIGHT, Suit.CLUBS));
    }

    @Test
    void testTakeTurn_whenCanPlayCard() {
        when(mockGame.getTopCard()).thenReturn(new Card(Rank.SEVEN, Suit.HEARTS));
        computerPlayer.takeTurn(mockGame);
        verify(mockGame).setTopCard(any(Card.class));
        assertEquals(1, computerPlayer.getHand().size());
    }

    @Test
    void testTakeTurn_whenCannotPlayCard() {
        when(mockGame.getTopCard()).thenReturn(new Card(Rank.JACK, Suit.SPADES));
        computerPlayer.takeTurn(mockGame);
        verify(mockGame).drawCard();
        assertEquals(3, computerPlayer.getHand().size());
    }
}