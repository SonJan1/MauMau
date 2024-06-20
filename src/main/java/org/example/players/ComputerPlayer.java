package org.example.players;

import org.example.Card;
import org.example.interfaces.Game;
import org.example.interfaces.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a computer player in the Mau Mau card game.
 */
public class ComputerPlayer implements Player {
    private final String name;
    private final List<Card> hand;

    public ComputerPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    @Override
    public void takeTurn(Game game) {
        System.out.println("It's " + name + "'s turn.");
        game.displayState();
        System.out.println("Computer's hand: " + hand);

        Card topCard = game.getTopCard();
        boolean played = false;
        for (Card card : hand) {
            if (canPlayCard(card, topCard)) {
                game.setTopCard(card);
                hand.remove(card);
                System.out.println("Computer played: " + card);
                played = true;
                break;
            }
        }

        if (!played) {
            Card drawnCard = game.drawCard();
            addCardToHand(drawnCard);
            System.out.println("Computer drew: " + drawnCard);
        }
    }

    private boolean canPlayCard(Card chosenCard, Card topCard) {
        return chosenCard.getSuit() == topCard.getSuit() || chosenCard.getRank() == topCard.getRank();
    }

    @Override
    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    @Override
    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public String toString() {
        return "ComputerPlayer{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
