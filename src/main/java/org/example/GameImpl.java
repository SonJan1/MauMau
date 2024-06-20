package org.example;

import org.example.interfaces.Game;
import org.example.interfaces.Player;
import org.example.players.HumanPlayer;
import org.example.players.PlayerFactory;

import java.util.*;

/**
 * The {@code GameImpl} class implements the {@code Game} interface and represents the main game logic for a card game.
 * It manages the players, the deck, and the gameplay mechanics.
 */
public class GameImpl implements Game {
    private List<Player> players;
    private Deck deck;
    private Card topCard;
    private boolean clockwise = true;
    private Suit wishedSuit;

    /**
     * Constructs a new {@code GameImpl} with the specified player names and types.
     *
     * @param playerNames    an array of player names
     * @param isHumanPlayers an array of booleans indicating whether each player is human (true) or computer (false)
     */
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

    /**
     * Adds a human player to the game.
     *
     * @param playerName the name of the player to add
     */
    public void addHumanPlayer(String playerName) {
        Player player = PlayerFactory.createPlayer(playerName, true);
        players.add(player);
    }

    /**
     * Removes a human player from the game by their name.
     *
     * @param playerName the name of the player to remove
     */
    public void removeHumanPlayer(String playerName) {
        for (Iterator<Player> iterator = players.iterator(); iterator.hasNext(); ) {
            Player player = iterator.next();
            if (player instanceof HumanPlayer && player.getName().equals(playerName)) {
                iterator.remove();
                break;
            }
        }
    }

    /**
     * Gets the list of players in the game.
     *
     * @return the list of players
     */
    public List<Player> getPlayers() {
        return players;
    }

    private int getNextPlayerIndex(int currentPlayerIndex) {
        if (clockwise) {
            return (currentPlayerIndex + 1) % players.size();
        } else {
            return (currentPlayerIndex - 1 + players.size()) % players.size();
        }
    }

    /**
     * Handles the effects of playing a special card.
     *
     * @param player the player who played the card
     * @param card   the special card played
     */
    public void handleSpecialCard(Player player, Card card) {
        switch (card.getRank()) {
            case SEVEN:
                handleSeven(player);
                break;
            case EIGHT:
                handleEight(player);
                break;
            case NINE:
                handleNine();
                break;
            case JACK:
                handleJack(player);
                break;
            default:
                break;
        }
    }

    private void handleSeven(Player player) {
        int cardsToDraw = 2;
        Player nextPlayer = players.get(getNextPlayerIndex(players.indexOf(player)));
        while (nextPlayer.getHand().stream().anyMatch(card -> card.getRank() == Rank.SEVEN)) {
            Card sevenCard = nextPlayer.getHand().stream().filter(card -> card.getRank() == Rank.SEVEN).findFirst().get();
            nextPlayer.playCard(this, sevenCard);
            cardsToDraw += 2;
            nextPlayer = players.get(getNextPlayerIndex(players.indexOf(nextPlayer)));
        }
        for (int i = 0; i < cardsToDraw; i++) {
            nextPlayer.addCardToHand(deck.drawCard());
        }
    }

    private void handleEight(Player player) {
        players.remove(player);
        System.out.println(player.getName() + " has been removed from the game.");
    }

    private void handleNine() {
        clockwise = !clockwise;
        System.out.println("Direction of play has been reversed.");
    }

    private void handleJack(Player player) {
        System.out.println("Jack played. Player " + player.getName() + " can wish for a suit.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a suit: DIAMOND, HEARTS, CLUBS, SPADES");
        String suitChoice = scanner.nextLine().toUpperCase();
        wishedSuit = Suit.valueOf(suitChoice);
        System.out.println("Player " + player.getName() + " wished for " + wishedSuit);
    }
}
