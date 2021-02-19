/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianhecker.lab_polymorphism;

/**
 *
 * @author hecker
 */
public abstract class Shape implements IDisplayable {
    protected double area;
    protected double perimeter;

    // Getters/Setters
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
        
    // Passed Methods
    public abstract void calculateArea();
    public abstract void calculatePerimeter();
    
}
