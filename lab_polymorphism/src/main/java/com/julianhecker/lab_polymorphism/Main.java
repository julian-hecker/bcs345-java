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
public class Main {
    public static void showAllData(IDisplayable[] d) {
        for (int i = 0; i < 4; i++) {    
            d[i].display();
        }
    }
    
    public static void oldMain(String[] args) {
        Shape[] s = new Shape[4];
        s[0] = new Circle(1);
        s[1] = new Rectangle(1,2);
        s[2] = new Circle(2);
        s[3] = new Rectangle(3,4);
        
        for (int i = 0; i < 4; i++) {
            s[i].calculateArea();
        }
    }
    
    public static void main(String[] args) {
        IDisplayable[] d = new IDisplayable[4];
        d[0] = new Circle(1);
        d[1] = new Rectangle(1,2);
        d[2] = new Circle(2);
        d[3] = new Rectangle(3,4);
        
        showAllData(d);
    }
}
