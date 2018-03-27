package com.thoughtworks.step;

import org.junit.Test;

public class AccountNumberTest {

    @Test(expected = InvalidAccountNumberException.class)
    public void checkingIfAccountNUmberIsInvalid() throws Exception {
        new AccountNumber("teja_1234");
    }

}
