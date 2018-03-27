package com.thoughtworks.step;

public class InsufficientFundException extends Exception{
    public InsufficientFundException() {
        super("Unable to process request due to insufficient balance in account");
    }
}
