package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransactionTest {
        Transaction trans;
        Date date ;
        float amount ;
    @Before
    public void setUp() throws Exception{
        date = new Date();
        amount = 1000;
        trans = new Transaction(date, amount);
    }

    @Test
    public void checksTheDateOfTransaction() {
        assertTrue(trans.getDate().equals(date));
    }

    @Test
    public void checksTheAmountOfTransaction() {
        assertEquals(trans.getAmount(),1000.0,0);
    }

}
