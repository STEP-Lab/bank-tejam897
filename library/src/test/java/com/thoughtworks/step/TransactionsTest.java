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
        ArrayList<Transaction> trans = transCollection.getTransactions();
        credit = transCollection.credit(1000,"teja");
        debit = transCollection.debit(1000,"teja");
    }

    @Test
    public void checksWhetherCreditTransactionsRecordedOrNot() {
//        ArrayList<Transaction> trans = transCollection.getTransactions();
        assertThat(transCollection.getTransactions(),hasItem (credit));
    }

    @Test
    public void checksWhetherDebitTransactionsRecordedOrNot() {
//        ArrayList<Transaction> trans = transCollection.getTransactions();
        assertThat(transCollection.getTransactions(),hasItem(debit));
    }

    @Test
    public void checksTheCollectingBackOfAllTransactions() {
        ArrayList<Transaction> trans = transCollection.getTransactions();
        assertThat(transCollection.getTransactions(),hasItems(credit,debit));
    }

    @Test
    public void checksCollectingBackOfAllCreditTransactionsFromWholeTransactions() {
        CreditTransaction TestingCredit = transCollection.credit(1000,"nani");
        Transactions creditTrans = transCollection.filterTransactionsByType(credit.getClass());
        ArrayList<Transaction> actual = creditTrans.getTransactions();
        assertThat(actual,hasItems(credit,TestingCredit));
    }
    @Test
    public void checksCollectingBackOfAllDebitTransactionsFromWholeTransactions() {
        DebitTransaction TestingDebit = transCollection.debit(1000,"nani");
        Transactions debitTrans = transCollection.filterTransactionsByType(debit.getClass());
        ArrayList<Transaction> actual = debitTrans.getTransactions();
        assertThat(actual,hasItems(debit,TestingDebit));
    }

    @Test
    public void checksCollectingBackOfAllTransactionsGreaterThanALimit() {
        float limit = 1000;
        DebitTransaction TestingTransAbove = transCollection.debit(1500,"nani");
        Transactions transAbove = transCollection.filterTransactionsAbove(limit);
        ArrayList<Transaction> actual = transAbove.getTransactions();
        assertThat( actual,hasItem(TestingTransAbove));
    }
    @Test
    public void checksCollectingBackOfAllTransactionsLesserThanALimit() {
        float limit = 500;
        DebitTransaction TestingTransBelow = transCollection.debit(400,"nani");
        Transactions transAbove = transCollection.filterTransactionsBelow(limit);
        ArrayList<Transaction> actual = transAbove.getTransactions();
        assertThat( actual,hasItem(TestingTransBelow));
    }
}