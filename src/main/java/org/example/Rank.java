package org.example;

/**
 * The {@code Rank} enum represents the rank of a playing card in a standard Skat deck.
 * Each rank has a corresponding name.
 */
public enum Rank {
    ACE("As", 11),
    KING("König", 4),
    QUEEN("Dame", 3),
    JACK("Bube", 2),
    TEN("10", 10),
    NINE("9", 0),
    EIGHT("8", 0),
    SEVEN("7", 0);

    private final String name;
    private final int value;

    Rank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
