package com.thoughtworks.step;

import java.util.ArrayList;

public class Transactions {
    private ArrayList<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<Transaction>();
    }

    public ArrayList getTransactions() {
        return transactions;
    }

    public CreditTransaction credit(float amount, String creditedBy) {
        CreditTransaction transaction = new CreditTransaction(amount,creditedBy);
        transactions.add(transaction);
        return transaction;
    }

    public DebitTransaction debit(float amount, String debitedBy) {
        DebitTransaction transaction = new DebitTransaction(amount,debitedBy);
        transactions.add(transaction);
        return transaction;
    }

    public ArrayList<Transaction> getTransactionsByType(Class<? extends Transaction> type) {
        ArrayList<Transaction> allTransactions = new ArrayList<>();
        ArrayList allTrans = getTransactions();
        int trans;
        for (trans = 0; trans<allTrans.size(); trans++){
            if(allTrans.get(trans).getClass().equals(type)){
                allTransactions.add((Transaction) allTrans.get(trans));
            }
        }
        return allTransactions;
    }

    public ArrayList<Transaction> getTransactionsAbove(float limit) {
        ArrayList<Transaction> allTransactions = new ArrayList<>();
        ArrayList allTrans = getTransactions();
        int trans;
        for (trans = 0; trans<allTrans.size(); trans++){
            if(allTrans.get(trans).getAmount()>limit) {
                allTransactions.add((Transaction) allTrans.get(trans));
            }
        }
        return allTransactions;
    }
}
