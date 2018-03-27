package com.thoughtworks.step;

import java.util.Date;

public class CreditTransaction {
    private float amount;
    private String creditedBy;
    private Date date;

    public CreditTransaction(Date date, float amount, String creditedBy) {
        this.date = date;
        this.amount = amount;
        this.creditedBy = creditedBy;
    }

    public CreditTransaction() {

    }
    public CreditTransaction(float amount, String creditedBy) {
        this.amount = amount;
        this.creditedBy = creditedBy;
    }

    public float getAmount() {
        return amount;
    }

    public String creditedBy() {
        return creditedBy;
    }

    public Date getDate() {
        return  date;
    }
}
