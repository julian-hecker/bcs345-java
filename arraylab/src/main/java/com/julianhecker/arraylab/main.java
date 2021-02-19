/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianhecker.arraylab;

/**
 *
 * @author hecker
 */
public class main {
    public static void main(String args[]) {
        int sales[] = new int[]{123,234,345,456,567};
        // Print to screen
        for (int item : sales) {
           System.out.println(item);
        }
        int total = 0;
        for (int item : sales) {
            total += item;
        }
        System.out.println("Average: " + total/sales.length);
        
        
        PersonData people = new PersonData();
        people.display();
        
        
    }
}
