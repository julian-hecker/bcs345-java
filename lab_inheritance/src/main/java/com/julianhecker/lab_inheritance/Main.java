/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianhecker.lab_inheritance;

/**
 *
 * @author hecker
 */
public class Main {
    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount("reee", 5000);
        InterestAccount thatAcc = new InterestAccount("boolean", 50000, .05);
        InterestAccount myOtherAcc = new InterestAccount("boolean", 0, .05);
        
        // Trying Deposits/Withdrawls
        myAcc.deposit(10);
        try {
            myAcc.withdraw(6000);
        } catch (InsufficientFunds ex) {
            System.out.println(ex);
        }
        thatAcc.deposit(10000);
        try {
            thatAcc.withdraw(10000);
        } catch (InsufficientFunds ex) {
            System.out.println(ex);
        }
        
        // Trying out interest
        System.out.println(thatAcc.getAccBalance());
        thatAcc.applyInterest();
        System.out.println(thatAcc.getAccBalance());
        
        // Customer
        Customer me = new Customer("boolean", myOtherAcc, thatAcc);
        System.out.println(me);
        me.depositChecking(1000);
        me.withdrawSavings(2000);
        me.withdrawChecking(50000);
        me.depositSavings(52000);
        System.out.println(me);
    }
}
