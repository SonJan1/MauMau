package org.example.interfaces;

import org.example.Card;

import java.util.List;

/**
 * The {@code Game} interface represents the core functionality required to manage and play a card game.
 */
public interface Game {
    /**
     * Initiates the game and manages its progression.
     * This method handles tasks such as dealing cards, determining the starting player,
     * and controlling the turn-based flow until the game concludes.
     */
    void start();

    /**
     * Displays the current state of the game.
     * Implement this method to output relevant information about the game state.
     * Typically, this includes showing the top card of the discard pile, displaying each player's current hand,
     * and any other relevant game-specific details.
     */
    void displayState();

    /**
     * Draws a card from the deck or the remaining cards in the game.
     *
     * @return The card drawn from the deck or pile.
     * Players draw cards during their turn to build their hand or to play immediately,
     * depending on the game rules.
     */
    Card drawCard();

    /**
     * Retrieves the current top card of the discard pile.
     *
     * @return The current top card of the discard pile.
     * Players use this method to determine which cards they can legally play on their turn,
     * based on the game's rules.
     */
    Card getTopCard();

    /**
     * Sets the top card of the discard pile to the provided card.
     *
     * @param card The card to set as the new top card of the discard pile.
     *             Call this method when a player makes a valid move by playing a card.
     *             It replaces the current top card with the played card, updating the game state accordingly.
     */
    void setTopCard(Card card);
}
