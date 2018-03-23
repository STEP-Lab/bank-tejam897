package com.thoughtworks.step;

import java.util.Currency;

public class Account {
    private final String name;
    private float bal;
    float minimumBalance = 500;


    public Account(String name, float bal) throws MinimumBalanceException {
        this.name = name;
        if (bal<minimumBalance) throw new MinimumBalanceException();
        this.bal = bal;
    }

    public float getBal() {
        return bal;
    }

    public float credit(float amount) {
        this.bal+=amount;
        return this.bal;
    }

    public float debit(float amount) throws InsufficientFundException {
        if(this.bal<amount) throw new InsufficientFundException();
        this.bal-=amount;
        return this.bal;
    }
}
