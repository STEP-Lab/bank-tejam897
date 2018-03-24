package com.thoughtworks.step;

public class AccountNumber {

    private static final String PATTERN = "\\d{4}[-]\\d{4}";
    private final String accNum;

    public AccountNumber(String accNum) throws InvalidAccountNumberException {
        validateAccountNumber(accNum);
        this.accNum = accNum;
    }

    private void validateAccountNumber(String accNum) throws InvalidAccountNumberException {
        if(!accNum.matches(PATTERN) ) throw new InvalidAccountNumberException();
    }


}
