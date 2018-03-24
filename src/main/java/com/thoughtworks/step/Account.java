package com.thoughtworks.step;

public class Account {
    private final AccountNumber name;
    private float bal;
    float minimumBalance = 500;


    public Account(AccountNumber accountNumber, float bal) throws MinimumBalanceException {
        this.name = accountNumber;
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
