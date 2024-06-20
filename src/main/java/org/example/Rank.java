package org.example;

/**
 * The {@code Rank} enum represents the rank of a playing card in a standard Skat deck.
 * Each rank has a corresponding name.
 */
public enum Rank {
    ACE("As", 1),
    KING("König", 10),
    QUEEN("Dame", 10),
    JACK("Bube", 10),
    TEN("10", 10),
    NINE("9", 10),
    EIGHT("8", 8),
    SEVEN("7", 7);

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
