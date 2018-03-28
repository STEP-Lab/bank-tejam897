package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    private Transactions transCollection;
    private CreditTransaction credit;
    private DebitTransaction debit;
    @Before
    public void setUp() throws Exception {
        transCollection = new Transactions();
        credit = transCollection.credit(1000,"teja");
        debit = transCollection.debit(1000,"teja");
    }

    @Test
    public void checksWhetherCreditTransactionsRecordedOrNot() {
        ArrayList<Transaction> trans = transCollection.getTransactions();
        assertThat(trans,hasItem (credit));
    }

    @Test
    public void checksWhetherDebitTransactionsRecordedOrNot() {
        ArrayList<Transaction> trans = transCollection.getTransactions();
        assertThat(trans,hasItem(debit));
    }

    @Test
    public void checksCollectingBackOfAllCreditTransactionsFromWholeTransactions() {
        CreditTransaction TestingCredit = transCollection.credit(1000,"nani");
        ArrayList<Transaction> creditTrans = transCollection.getTransactionsByType(credit.getClass());
        assertThat(creditTrans,hasItems(credit,TestingCredit));
    }
    @Test
    public void checksCollectingBackOfAllDebitTransactionsFromWholeTransactions() {
        DebitTransaction TestingDebit = transCollection.debit(1000,"nani");
        ArrayList<Transaction> debitTrans = transCollection.getTransactionsByType(debit.getClass());
        assertThat(debitTrans,hasItems(debit,TestingDebit));
    }

    @Test
    public void checksCollectingBackOfAllTransactionsGreaterThanALimit() {
        float limit = 1000;
        DebitTransaction TestingTransAbove = transCollection.debit(1500,"nani");
        ArrayList<Transactions> transAbove = transCollection.getTransactionsAbove(limit);
        assertThat( transAbove,hasItem(TestingTransAbove));
    }
}
