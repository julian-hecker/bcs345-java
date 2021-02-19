/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianhecker.exam1;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author Julian Hecker
 */
public class Main {
    public static void main(String[] args) {
        Money money[] = new Money[20];
        String filename = "infile.txt";
        Scanner fr = null;
        try {
            fr = new Scanner(new File(filename));
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
        
        int j = 0;
        while (fr.hasNextLine()) {
            int dollars = 0;
            int cents = 0;
            String[] line = fr.nextLine().split(" ");
            dollars = parseInt(line[0]);
            cents = parseInt(line[1]);
            money[j] = new Money(dollars, cents);
            j++;
        }
        
        int totalDollars = 0;
        int totalCents = 0;
        Money totalMoney;
        for (int i = 0; i < money.length; i++) {
            totalDollars += money[i].getDollars();
            totalCents += money[i].getCents();
        }
        
        while (totalCents >= 100) { // make sure cents < 100
            totalDollars += 1;
            totalCents -= 100;
        }
        totalMoney = new Money(totalDollars, totalCents);
        System.out.println(totalMoney);
        System.out.println(totalMoney == money[1]); // should be false
        System.out.println(money[1] == money[1]); // should be true
    }
}

