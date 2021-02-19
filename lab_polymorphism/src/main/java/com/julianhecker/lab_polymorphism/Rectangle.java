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
public class Rectangle extends Shape {
    protected double width;
    protected double length;
    
    // Constructor
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    
    // Getters/Setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    // Inheritance and Implementation Overrides
    @Override
    public void calculateArea() {
        area = width * length;
    }
    
    @Override
    public void calculatePerimeter() {
        perimeter = 2 * width + 2 * length;
    }
    
    @Override
    public void display() {
        this.calculateArea();
        this.calculatePerimeter();
        System.out.printf("Width: %s;\tLength: %s;\tArea: %s;\tPerimeter: %s;%n", width, length, area, perimeter);
    }
}
