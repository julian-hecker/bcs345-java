package com.julianhecker.presentation;

import com.julianhecker.business.TimeSheet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Main class, runs presentation code for the business package
 * @author Julian Hecker
 */
public class Main {
    /**
     * Displays the UI for TimeSheet
     * @author Julian Hecker
     * @since 11/1/2020
     */
    public static void displayUI() {
        System.out.print(
            "Shift UI\n" +
            "========\n" +
            "1 - Read TimeSheet from file as JSON\n" +
            "2 - Write TimeSheet to file as JSON\n" +
            "3 - Shift at index\n" +
            "4 - Biggest Longest Shift\n" +
            "5 - TimeSheet Report\n" +
            "6 - TimeSheet toString\n" + 
            "7 - Exit\n" +
            "Note: You must read from a file before running other commands\n" +
            "Enter your choice: \n"
        );

    }
    
    private static void readTimeSheet(TimeSheet ts) {
        Scanner in = new Scanner(System.in);
        System.out.println("What filename to read from?");
        String filename = in.nextLine();
        FileReader fr = null;
        try {
            System.out.println("Opening file " + filename + "...");
            fr = new FileReader(filename);
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
        ts.readJSON(fr);
        System.out.println("JSON File Read!");
    }
    /**
     * writeShift: Call's Shift's writeJson method, to write data to JSON file.
     * @param shift
     */
    private static void writeTimeSheet(TimeSheet ts) {
        Scanner in = new Scanner(System.in);
        System.out.println("What filename to write to?");
        String filename = in.nextLine();
        PrintStream ps = null;
        try {
            ps = new PrintStream(filename);
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
        ts.writeJSON(ps);
        System.out.println("JSON File Written!");
    }
    
    
    private static void getAtIndex(TimeSheet ts) {
        Scanner in = new Scanner(System.in);
        int index = 0;
        System.out.println("Get shift at which index?");
        index = in.nextInt();
        try {
            System.out.println(ts.getAt(index));
        } catch (ArrayIndexOutOfBoundsException err) {
            System.out.println("Invalid index! " + err);
        }
    }
    
    private static void reportTimeSheet(TimeSheet ts) {
        Scanner in = new Scanner(System.in);
        System.out.println("What filename to write report to?");
        String filename = in.nextLine();
        PrintStream ps = null;
        try {
            ps = new PrintStream(filename);
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
        ts.report(ps);
        System.out.println("Report written to file!");

    }

    
    /**
     * tsProgramLoop, loop for the program that deals with TimeSheets
     * @author Julian Hecker
     * @since 11/1/2020
     */
    public static void tsProgramLoop(TimeSheet ts) {
        Scanner in = new Scanner(System.in);
        char c;
        OUTER:
        while (true) {
            displayUI();
            c = in.next().charAt(0);
            switch (c) {
                case '1':
                    readTimeSheet(ts);
                    break;
                case '2':
                    writeTimeSheet(ts);
                    break;
                case '3':
                    getAtIndex(ts);
                    break;
                case '4':
                    System.out.println("Shift with most hours:\n" + ts.getMaxShift());
                    break;
                case '5':
                    reportTimeSheet(ts);
                    break;
                case '6': 
                    System.out.println(ts);
                    break;
                case '7':
                    System.out.println("bai bai!");
                    break OUTER;
                default:
                    System.out.println("You must select an option 1-7. Please try again.");
            }
        }
    }
    
    /**
     * Main Method, executes presentation code
     * @author Julian Hecker
     * @param args[]
     */
    public static void main(String[] args) {
        TimeSheet ts = new TimeSheet();
        tsProgramLoop(ts);
    }
}
