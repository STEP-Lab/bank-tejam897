package com.thoughtworks.step;

import java.util.Date;

public class Transaction {
    private Date date;
    private float amount;

    public Transaction(Date date, float amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }
}
