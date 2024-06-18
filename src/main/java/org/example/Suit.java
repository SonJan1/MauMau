package org.example;

public enum Suit {
    DIAMOND("Ecken"),
    HEARTS("Herzen"),
    CLUBS("Kreuze"),
    SPADES("Piks");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
