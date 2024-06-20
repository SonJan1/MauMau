package org.example;

import org.example.interfaces.Game;

public class Main {
    public static void main(String[] args) {
        String[] playerNames = {"Player 1", "Player 2", "Player 3"};
        boolean[] isHumanPlayers = {true, false, false};
        Game game = new GameImpl(playerNames, isHumanPlayers);
        game.start();
    }
}

