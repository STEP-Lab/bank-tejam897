package com.thoughtworks.step;

public class MinimumBalanceException extends Exception{
    public MinimumBalanceException() {
        super("Unable to create account with given amount. Please create account with minimum balance 500");
    }
}
