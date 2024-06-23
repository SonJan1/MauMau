package org.example;

/**
 * The {@code Suit} enum represents the suit of a playing card in a standard Skat deck.
 * Each suit has a corresponding name.
 */
public enum Suit {
    DIAMONDS("Ecken ♦"),
    HEARTS("Herzen ♥"),
    CLUBS("Kreuze ♣"),
    SPADES("Piks ♠");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
