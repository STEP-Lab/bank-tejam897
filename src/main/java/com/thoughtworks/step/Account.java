package com.thoughtworks.step;

public class Account {
    private final String name;
    private int bal;

    public Account(String name, int bal) {
        this.name = name;
        this.bal = bal;
    }

    public int getBal() {
        return bal;
    }

    public int credit(int amount) {
        this.bal+= amount;
        return this.bal;
    }

    public int debit(int amount) {
        this.bal-=amount;
        return this.bal;
    }
}
