package com.thoughtworks.step;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account teja;
    @Before
    public void setUp() throws Exception {
        AccountNumber accNum = new AccountNumber("1234-1234");
        teja = new Account(accNum, 1000);
    }

    @Test
    public void getBal() {
     assertThat(teja.getBal(), is(1000.0F));
    }

    @Test
    public void credit() {
        Assert.assertThat(teja.credit(1000), Is.is(2000.0F));
    }

    @Test
    public void debit() throws InsufficientFundException {
        Assert.assertThat(teja.debit(1000), Is.is(0.0F));
    }

    @Test(expected = InsufficientFundException.class)
    public void checkingIfFundsAreInsufficientForWithdrawl() throws InsufficientFundException {
        teja.debit(1200);
    }

    @Test(expected = MinimumBalanceException.class)
    public void minimumBalanceCheckingForCreatingAccount() throws Exception {
        AccountNumber invalidAccNum = new AccountNumber("1234-1234");
        Account account = new Account(invalidAccNum, 400);
    }

}