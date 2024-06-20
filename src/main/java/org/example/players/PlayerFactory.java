package org.example.players;

import org.example.interfaces.Player;

/**
 * The {@code PlayerFactory} class provides a static method to create instances of {@code Player}.
 * Depending on the specified type (human or computer), it returns an instance of {@code HumanPlayer} or {@code ComputerPlayer}.
 */
public class PlayerFactory {
    /**
     * Creates a new player instance based on the specified parameters.
     *
     * @param name    the name of the player
     * @param isHuman if true, creates a {@code HumanPlayer}; if false, creates a {@code ComputerPlayer}
     * @return a {@code Player} instance (either {@code HumanPlayer} or {@code ComputerPlayer})
     */
    public static Player createPlayer(String name, boolean isHuman) {
        if (isHuman) {
            return new HumanPlayer(name);
        } else {
            return new ComputerPlayer(name);
        }
    }
}
