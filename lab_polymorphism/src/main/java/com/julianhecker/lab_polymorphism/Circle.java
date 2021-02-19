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
public final class Circle extends Shape {
    protected double radius;
    
    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Getters/Setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
    // Inheritance and Implementation Overrides
    @Override
    public void calculateArea() {
        area = 3.14 * Math.pow(radius, 2);
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * 3.14 * radius;
    }
    
    @Override
    public void display() {
        this.calculateArea();
        this.calculatePerimeter();
        System.out.printf("Radius: %s;\tArea: %s;\tPerimeter: %s;%n", radius, area, perimeter);
    }
}
