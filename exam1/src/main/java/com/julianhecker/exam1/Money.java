package com.julianhecker.exam1;

/**
 *
 * @author Julian Hecker
 */
public class Money {
    private int dollars;
    private int cents;
    
    // Constructors
    public Money() {
        this.dollars = 0;
        this.cents = 0;
    }
    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }
    // Getters, Setters
    public int getDollars() {
        return dollars;
    }
    public void setDollars(int dollars) {
        this.dollars = dollars;
    }
    public int getCents() {
        return cents;
    }
    public void setCents(int cents) {
        this.cents = cents;
    }
    // Methods
    @Override
    public String toString() {
        return String.format("$%,d.%02d", dollars, cents);
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Money) {
            Money rhs;
            rhs = (Money)other; // Cast object as Money type
            return (rhs.dollars == this.dollars && rhs.cents == this.cents);
        } else {
            return false;
        }
    }    
}
