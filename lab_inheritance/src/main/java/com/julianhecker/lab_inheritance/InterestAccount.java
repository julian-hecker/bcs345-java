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
public class InterestAccount extends BankAccount {
    // Members
    protected double interest;
    
    // Constructors
    public InterestAccount(String accName, double accBalance, double interest) {
        super(accName, accBalance);
        this.interest = interest;
    }
    
    // Getters/Setters
    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    // Methods
    public void applyInterest() {
        this.accBalance *= (1 + interest);
    }
    
}
