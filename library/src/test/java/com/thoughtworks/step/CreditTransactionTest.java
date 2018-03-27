package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreditTransactionTest {
    private CreditTransaction credit;
    @Before
    public void setUp() {
        credit = new CreditTransaction( 1000, "teja");
    }

    @Test
    public void checksCreditTransactionAmount() {
        assertEquals(credit.getAmount(),1000,0);
    }

    @Test
    public void checksCreditedByWhom() {
        assertThat(credit.creditedBy(),is("teja"));
    }

    @Test
    public void checksTheDateOfTransactionHappens() {
        Date date = new Date();
        CreditTransaction trans = new CreditTransaction(date,1000, "teja");
        assertTrue(trans.getDate().equals(date));
    }
}
