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
public class Customer {
    private String name;
    private InterestAccount savings;
    private InterestAccount checking;
    
    // Constructors
    public Customer() {
        this.name = "";
        this.savings = null;
        this.checking = null;
    }
    
    public Customer(String name, InterestAccount savings, InterestAccount checking) {
        this.name = name;
        this.savings = savings;
        this.checking = checking;
    }
    
    // Getters/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InterestAccount getSavings() {
        return savings;
    }

    public void setSavings(InterestAccount savings) {
        this.savings = savings;
    }

    public InterestAccount getChecking() {
        return checking;
    }

    public void setChecking(InterestAccount checking) {
        this.checking = checking;
    }
    
    // Methods
    public void depositSavings(double amount) {
        this.savings.deposit(amount);
    }
    
    public void withdrawSavings(double amount) {
        try {
            this.savings.withdraw(amount);
        } catch (InsufficientFunds ex) {
            System.out.println(ex);
        }
    }
    
    public void depositChecking(double amount) {
        this.checking.deposit(amount);
    }
    
    public void withdrawChecking(double amount) {
        try {
            this.checking.withdraw(amount);
        } catch (InsufficientFunds ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s's Account: Savings: $%.2f; Checking: $%.2f;", this.getName(), this.savings.getAccBalance(), this.checking.getAccBalance());
    }
    
}
