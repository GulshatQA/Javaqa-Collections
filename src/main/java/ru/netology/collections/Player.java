package ru.netology.collections;
public class Player {
    protected int id;
    protected String playerName;
    protected int strength;

    public Player(int id, String playerName, int strength) {
        this.id = id;
        this.playerName = playerName;
        this.strength = strength;
    }

    public String getName() {
        return playerName;
    }

    public int getStrength() {
        return strength;
    }
}
