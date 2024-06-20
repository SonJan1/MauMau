package org.example;

/**
 * The {@code Rank} enum represents the rank of a playing card in a standard Skat deck.
 * Each rank has a corresponding name.
 */
public enum Rank {
    ACE("As"),
    KING("König"),
    QUEEN("Dame"),
    JACK("Bube"),
    TEN("10"),
    NINE("9"),
    EIGHT("8"),
    SEVEN("7");

    private final String name;

    Rank(String name) {
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
