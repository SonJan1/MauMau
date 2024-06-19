package org.example.players;

import org.example.interfaces.Player;

public class PlayerFactory {
    public static Player createPlayer(String name, boolean isHuman) {
        if (isHuman) {
            return new HumanPlayer(name);
        } else {
            return new ComputerPlayer(name);
        }
    }
}
