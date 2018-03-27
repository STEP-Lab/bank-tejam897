package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DebitTransactionTest {
    private DebitTransaction debit;
    @Before
    public void setUp() throws Exception {
        debit = new DebitTransaction(1000, "teja");
    }

    @Test
    public void checksDebitedByWhom() {
        assertThat(debit.debitedBy(),is("teja"));
    }
}
