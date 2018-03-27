package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CreditTransactionTest {
    private CreditTransaction credit;
    @Before
    public void setUp() {
        credit = new CreditTransaction( 1000, "teja");
    }
    @Test
    public void checksCreditedByWhom() {
        assertThat(credit.creditedBy(),is("teja"));
    }


}
