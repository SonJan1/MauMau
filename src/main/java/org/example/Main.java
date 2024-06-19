package org.example;

import org.example.interfaces.Game;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Deck deck = new Deck();
//        Set<Card> cardSet = new HashSet<>(deck.cards);
//
//        if (cardSet.size() == deck.size()) {
//            System.out.println("Das Deck ist korrekt initialisiert, es gibt keine Duplikate.");
//        } else {
//            System.out.println("Duplikate im Deck erkannt!");
//        }
//
//        System.out.println("Alle Karten im Deck:");
//        for (Card card : deck.cards) {
//            System.out.println(card);
//        }

        String[] playerNames = {"Player 1", "Player 2", "Player 3"};
        boolean[] isHumanPlayers = {true, false, false}; // Player 1 is human, Player 2 and Player 3 are computers
        Game game = new GameImpl(playerNames, isHumanPlayers);
        game.start();
    }
}

