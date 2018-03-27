package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction{
    private String debitedBy;

    public DebitTransaction(float amount, String debitedBy) {
        super(new Date(),amount);
        this.debitedBy = debitedBy;
    }

    public String debitedBy() {
        return debitedBy;
    }
}
