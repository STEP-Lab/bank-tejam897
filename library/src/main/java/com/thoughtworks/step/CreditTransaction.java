package com.thoughtworks.step;

import java.util.Date;

public class CreditTransaction extends Transaction{
    private String creditedBy;

    public CreditTransaction(float amount, String creditedBy) {
        super(new Date(),amount);
        this.creditedBy = creditedBy;
    }
    public String creditedBy() {
        return creditedBy;
    }
}
