package org.example.players;

import org.example.Card;
import org.example.interfaces.Game;
import org.example.interfaces.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a human player in the Mau Mau card game.
 */
public class HumanPlayer implements Player {
    private final String name;
    private final List<Card> hand;

    public HumanPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    @Override
    public void takeTurn(Game game) {
        System.out.println("It's " + name + "'s turn.");
        game.displayState();
        System.out.println("Your hand: " + hand);
        Scanner scanner = new Scanner(System.in);
        boolean validMove = false;

        while (!validMove) {
            System.out.println("Choose a card to play (index 0-" + (hand.size() - 1) + ") or draw a card (-1): ");
            int choice = scanner.nextInt();

            if (choice == -1) {
                Card drawnCard = game.drawCard();
                addCardToHand(drawnCard);
                System.out.println("You drew: " + drawnCard);
                validMove = true;
            } else if (choice >= 0 && choice < hand.size()) {
                Card chosenCard = hand.get(choice);
                if (canPlayCard(chosenCard, game.getTopCard())) {
                    game.setTopCard(chosenCard);
                    removeCardFromHand(chosenCard);
                    validMove = true;
                } else {
                    System.out.println("Invalid move. Choose a different card.");
                }
            }
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
        return hand.isEmpty();
    }

    @Override
    public int getScore() {
        int score = 0;
        for (Card card : hand) {
            score += card.getRank().getValue();
        }
        return score;
    }

    @Override
    public void playCard(Game game, Card card) {
        removeCardFromHand(card);
        game.setTopCard(card);
        game.handleSpecialCard(this, card);
    }

    @Override
    public String toString() {
        return "HumanPlayer{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
