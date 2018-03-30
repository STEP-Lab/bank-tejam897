
package com.thoughtworks.step;

import java.util.ArrayList;

public class Transactions {
    public ArrayList<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<Transaction>();
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public CreditTransaction credit(float amount, String creditedBy) {
        CreditTransaction transaction = new CreditTransaction(amount,creditedBy);
        this.transactions.add(transaction);
        return transaction;
    }

    public DebitTransaction debit(float amount, String debitedBy) {
        DebitTransaction transaction = new DebitTransaction(amount,debitedBy);
        this.transactions.add(transaction);
        return transaction;
    }

    public Transactions filterTransactionsByType(Class<? extends Transaction> type) {
        Transactions allTransactions = new Transactions();
        for (Transaction transaction : transactions) {
            if(transaction.getClass().equals(type)){
                allTransactions.transactions.add(transaction);
            }
        }
        return allTransactions;
    }

    public Transactions filterTransactionsAbove(float limit) {
        Transactions allTransactions = new Transactions();
        for (Transaction transaction : transactions) {
            if(transaction.getAmount()>limit){
                allTransactions.transactions.add(transaction);
            }
        }
        return allTransactions;
    }

    public Transactions filterTransactionsBelow(float limit) {
        Transactions allTransactions = new Transactions();
        for (Transaction transaction : transactions) {
            if(transaction.getAmount()<limit){
                allTransactions.transactions.add(transaction);
            }
        }
        return allTransactions;
    }
}
