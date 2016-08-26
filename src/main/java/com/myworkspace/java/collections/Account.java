package com.myworkspace.java.collections;

import java.math.BigDecimal;
import java.util.Date;

class Account {
    private int creditLimit;
    private BigDecimal accountBalance;
    private Date acctOpenedDate;


    public boolean checkAccountAge() {
        return false;

    }

    public boolean checkAcctCurrentBalance(double balance) {
        BigDecimal balanceDecimal = BigDecimal.valueOf(balance);

        if (balanceDecimal.signum() >= 0 && balance <= 10000)
            return true;
        else
            return false;
    }

    public boolean checkAcctCreditLimit(BigDecimal creditLimit) {
       /* if (creditLimit >= 1000 && creditLimit <= 10000)
            return true;
        else*/
            return false;
    }

}


class AccountMain {
    public static void main(String[] args) {

    }
}