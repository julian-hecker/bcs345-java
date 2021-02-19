package com.julianhecker.lab2;

import java.io.FileReader;
import static java.lang.Double.parseDouble;
import java.util.Scanner;

/**
 * The Sales Person Class
 * @author Julian Hecker
 * @version 1.0
 * @since 9/12/2020
 */
public class SalesPerson {
    public static void main(String[] args) {
        SalesPerson jim = new SalesPerson();
        jim.setName("Jim");
        jim.setTotal(4000.12);
        System.out.printf("Name: %s%nTotal: %.2f%n", jim.getName(), jim.getTotal());
        jim.statusMessage();
        jim.quotaDifference();
        
        String infileName = "salespeople.txt";
        Scanner infile = null;
        // Create input file scanner
        try {
            infile = new Scanner(new FileReader(infileName));
        } catch (Exception ex) {
            System.out.println("Error! \n" + ex);
        }
        
        // https://stackoverflow.com/questions/13927326/reading-input-till-eof-in-java
        SalesPerson[] salespeople = new SalesPerson[20];
        int i = 0;
        while(infile.hasNextLine()) {
            String salespersontext;
            salespersontext = infile.nextLine();
            String salespersonname = salespersontext.split(" ")[0];
            double salespersontotal = parseDouble(salespersontext.split(" ")[1]);
            salespeople[i] = new SalesPerson();
            salespeople[i].setName(salespersonname);
            salespeople[i].setTotal(salespersontotal);
            SalesPerson person = salespeople[i];
            System.out.printf("Name: %s%nTotal: %.2f%nDiff: %.2f%n", person.getName(), person.getTotal(), person.quotaDifference());
            
            i++;
        }
        
    }
    // Private Variables
    private static String name;
    private static double total;
    
    // Getters
    public String getName() {
        return name;
    }
    public double getTotal() {
        return total;
    }
    // Setters
    public void setName(String newName) {
        name = newName;
    }
    public void setTotal(double newTotal) {
        total = newTotal;
    }
    // Other Public Methods
    public void statusMessage() {
        if (total >= 100) {
            System.out.println("Performing well");
        } else {
            System.out.println("Not meeting expectations");
        }
    }
    public double quotaDifference() {
        return total - 100;
    }
    
    
}
