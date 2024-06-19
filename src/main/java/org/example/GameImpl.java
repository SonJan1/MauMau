package org.example;

import org.example.interfaces.Game;
import org.example.interfaces.Player;
import org.example.players.HumanPlayer;
import org.example.players.PlayerFactory;

import java.util.*;

public class GameImpl implements Game {
    private List<Player> players;
    private Deck deck;
    private Card topCard;

    public GameImpl(String[] playerNames, boolean[] isHumanPlayers) {
        this.players = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            Player player = PlayerFactory.createPlayer(playerNames[i], isHumanPlayers[i]);
            players.add(player);
        }
        this.deck = new Deck();
        this.topCard = deck.drawCard();
    }

    @Override
    public void start() {
        dealCards();
        int currentPlayerIndex = new Random().nextInt(players.size());
        Player currentPlayer = players.get(currentPlayerIndex);

        while (!gameOver()) {
            currentPlayer.takeTurn(this);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            currentPlayer = players.get(currentPlayerIndex);
        }

        endGame();
    }

    @Override
    public void displayState() {
        System.out.println("Top card: " + topCard);
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand: " + player.getHand());
        }
    }

    @Override
    public Card drawCard() {
        return deck.drawCard();
    }

    @Override
    public Card getTopCard() {
        return topCard;
    }

    @Override
    public void setTopCard(Card card) {
        this.topCard = card;
    }

    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                Card card = deck.drawCard();
                player.addCardToHand(card);
            }
        }
    }

    private boolean gameOver() {
        for (Player player : players) {
            if (player.hasWon()) {
                return true;
            }
        }
        return false;
    }

    private void endGame() {
        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, (p1, p2) -> Integer.compare(p1.getScore(), p2.getScore()));
        Collections.reverse(sortedPlayers);

        for (int i = 0; i < sortedPlayers.size(); i++) {
            Player player = sortedPlayers.get(i);
            System.out.println("Rank " + (i + 1) + ": " + player.getName() + " (Score: " + player.getScore() + ")");
        }
    }

    public void addHumanPlayer(String playerName) {
        Player player = PlayerFactory.createPlayer(playerName, true);
        players.add(player);
    }

    public void removeHumanPlayer(String playerName) {
        for (Iterator<Player> iterator = players.iterator(); iterator.hasNext(); ) {
            Player player = iterator.next();
            if (player instanceof HumanPlayer && player.getName().equals(playerName)) {
                iterator.remove();
                break;
            }
        }
    }
}
