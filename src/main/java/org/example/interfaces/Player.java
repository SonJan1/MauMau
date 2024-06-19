package org.example.interfaces;

import org.example.Card;

import java.util.List;

public interface Player {
    void takeTurn(Game game);
    List<Card> getHand();
    String getName();
    void addCardToHand(Card card);
    void removeCardFromHand(Card card);
    boolean hasWon();
    int getScore();
}
