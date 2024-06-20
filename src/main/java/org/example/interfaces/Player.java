package org.example.interfaces;

import org.example.Card;

import java.util.List;

/**
 * The {@code Player} interface represents a participant in a card game.
 * Players interact with the game by taking turns, managing their hand of cards,
 * and tracking their game-related statistics.
 */
public interface Player {
    /**
     * Executes the player's turn in the game.
     *
     * @param game The game instance that manages the game state.
     *             Implementations of this method should interact with the game to make decisions and actions
     *             based on the current game state.
     */
    void takeTurn(Game game);

    /**
     * Retrieves the current hand of cards held by the player.
     *
     * @return The list of cards in the player's hand.
     * Players use their hand to play cards during their turn and to strategize based on game rules.
     */
    List<Card> getHand();

    /**
     * Retrieves the name of the player.
     *
     * @return The name of the player.
     * Each player is uniquely identified by their name in the game.
     */
    String getName();

    /**
     * Adds a card to the player's hand.
     *
     * @param card The card to be added to the player's hand.
     *             Players receive cards during the game, either through drawing from the deck or other game actions.
     */
    void addCardToHand(Card card);

    /**
     * Removes a card from the player's hand.
     *
     * @param card The card to be removed from the player's hand.
     *             Players typically remove cards when they are played or discarded according to game rules.
     */
    void removeCardFromHand(Card card);

    /**
     * Checks if the player has won the game.
     *
     * @return {@code true} if the player has no cards left in their hand (indicating they have won the game),
     * {@code false} otherwise.
     */
    boolean hasWon();

    /**
     * Retrieves the current score of the player.
     *
     * @return The score of the player based on the cards they hold or other game-specific criteria.
     * Players may accumulate score points throughout the game based on their performance or actions.
     */
    int getScore();

    /**
     * Plays a card during the player's turn.
     *
     * @param game the current game instance
     * @param card the card to play
     */
    void playCard(Game game, Card card);
}
