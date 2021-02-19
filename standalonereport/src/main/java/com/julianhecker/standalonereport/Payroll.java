package com.julianhecker.standalonereport;

import java.io.FileReader;
import java.io.PrintStream;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 * Uses a specified input file to generate <b>Payroll Reports</b> to a specified location.
 * @author Julian Hecker
 * @version 1.0
 * @since 9/12/2020
 */
public class Payroll {
    /**
     * Main Method: get filenames from users and opens files.
     * @author Julian Hecker
     * @version 1.0
     * @since 9/12/2020
     * @return void
     */

    public static void main(String[] args) {
        // Define variables
        String infileName;
        String outfileName;
        Scanner textScanner = new Scanner(System.in);
        // Create uninitialized classes
        PrintStream outfile = null;
        Scanner infile = null;
        
        // Get input file name
        System.out.println("Generate report from which input file?");
        infileName = textScanner.nextLine();
        // Get output file name
        System.out.println("Generate report to what file?");
        outfileName = textScanner.nextLine();
        
        // Create input file scanner
        try {
            infile = new Scanner(new FileReader(infileName));
        } catch (Exception ex) {
            System.out.println("Error! \n" + ex);
        }
        
        // Create output file
        try {
            outfile = new PrintStream(outfileName);
        } catch (Exception ex) {
            System.out.println("Error! \n" + ex);
        }
        
        // Send files to processFile function
        processFile(infile, outfile);
    }
    
    /**
     * processFile gathers data from input file, creates and formats output file.
     * @param infile
     * @param outfile 
     * @return void
     */
    
    private static void processFile(Scanner infile, PrintStream outfile) {
        // Get non-repeating fields from input file
        String firstName = infile.nextLine();
        String lastName = infile.nextLine();
        String id = infile.nextLine();
        double payrate = parseDouble(infile.nextLine());
        int shiftCount = parseInt(infile.nextLine());
        // Create arrays for the repeating fields
        int months[] = new int[shiftCount];
        int days[] = new int[shiftCount];
        int years[] = new int[shiftCount];
        double hours[] = new double[shiftCount];
        double pay[] = new double[shiftCount];
        // Accumulators for totals
        double totalHours = 0;
        double totalPay = 0;
                
        // Get repeating fields (month, day, year, hoursWorked) from input file
        for (int i = 0; i < shiftCount; i++) {
            months[i] = parseInt(infile.nextLine());
            days[i] = parseInt(infile.nextLine());
            years[i] = parseInt(infile.nextLine());
            hours[i] = parseDouble(infile.nextLine());
            pay[i] = hours[i] * payrate;
            totalHours += hours[i];
            totalPay += pay[i];
        }
        
        // Print report header
        outfile.println(
                "Payroll Report\n" 
              + "=============="
        );
        // Print non-repeating fields
        outfile.printf(
                "First:\t%s%n"
              + "Last:\t%s%n"
              + "Id:\t%s%n"
              + "Rate:\t%.2f%n%n",
                firstName, lastName, id, payrate
        );
        
        // Thanks to this resource for printf tutorial
        // https://www.cs.colostate.edu/~cs160/.Summer16/resources/Java_printf_method_quick_reference.pdf
        outfile.printf("%5S%5S%6S%7S%9S%n", "Month", "Day", "Year", "Hours", "Pay");
        outfile.println("--------------------------------");
        // Print repeating fields
        for (int i = 0; i < shiftCount; i++) {
            outfile.printf("%4d%5d%7d%7.2f%,9.2f%n", months[i], days[i], years[i], hours[i], pay[i]);
        }
        outfile.println("--------------------------------");
        outfile.printf("Total%18.2f %8.2f%n", totalHours, totalPay);
    }

}
