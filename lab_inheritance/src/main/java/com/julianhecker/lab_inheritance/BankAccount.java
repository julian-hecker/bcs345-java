/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianhecker.lab_inheritance;


class InsufficientFunds extends Exception {
    private double balance;
    private double amount;

    public InsufficientFunds(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return String.format("Insufficient Funds! Cannot withdraw; $%.2f from account with $%.2f!", amount, balance);
    }
    
}

public class BankAccount {
    // Members
    protected String accName;
    protected double accBalance;
    
    // Constructors
    public BankAccount() {
        this.accName = "";
        this.accBalance = 0;
    }
    
    public BankAccount(String accName, double accBalance) {
        this.accName = accName;
        this.accBalance = accBalance;
    }
    
    // Getters/Setters
    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }
    
    // Methods
    public void deposit(double amount) {
        this.accBalance += amount;
    }
    
    public void withdraw(double amount) throws InsufficientFunds {
        if (this.accBalance - amount > 0) {
            this.accBalance -= amount;
        } else {
            InsufficientFunds err = new InsufficientFunds(accBalance, amount);
            throw err;
        }
    }    
}
