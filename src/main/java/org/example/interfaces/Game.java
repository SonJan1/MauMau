package org.example.interfaces;

import org.example.Card;

import java.util.List;

public interface Game {
    void start();
    void displayState();
    Card drawCard();
    Card getTopCard();
    void setTopCard(Card card);
}
