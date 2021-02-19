package com.julianhecker.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.FileReader;
import java.io.PrintStream;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * TimeSheet class, keeps track of workers and their shifts worked.
 * @author Julian Hecker
 * @since 10/31/2020
 */
public class TimeSheet {
    @SerializedName("worker")
    private Worker worker;
    @SerializedName("shifts")
    private Shift[] shifts;
    
    /**
     * Default Constructor, sets values to null
     * @author Julian Hecker
     * @since 11/1/2020
     */
    public TimeSheet() {
        this.worker = null;
        this.shifts = null;
    }
    
    // Getters/Setters
    /**
     * getWorkers, returns the instance's worker value
     * @author Julian Hecker
     * @since 11/1/2020
     * @returns worker
     */
    public Worker getWorker() {
        return worker;
    }

    /**
     * setWorker, sets the instance's value for worker
     * @author Julian Hecker
     * @since 11/1/2020
     * @param worker 
     */
    public void setWorker(Worker worker) {
        this.worker = worker;
    }
    
    /**
     * getAt, returns the shift at given index
     * @author Julian Hecker
     * @since 11/1/2020
     * @param index
     * @return shift
     * @throws ArrayIndexOutOfBoundsException if index invalid
     */
    public Shift getAt(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > shifts.length) {
            ArrayIndexOutOfBoundsException err = new ArrayIndexOutOfBoundsException(index);
            throw err;
        }
        return shifts[index];
    }
    
    /**
     * getMaxShift, returns shift with highest number of hours
     * @author Julian Hecker
     * @since 11/1/2020
     * @return shift
     */
    public Shift getMaxShift() {
        Shift temp = new Shift();
        for (Shift shift : shifts) {
            if (shift.getHoursWorked() > temp.getHoursWorked()) {
                temp = shift;
            }
        }
        return temp;
    }
    
    /**
     * report, writes a TimeSheet report to the given PrintStream instance.
     * @author Julian Hecker
     * @since 11/4/2020
     * @param ps PrintStream
     */
    public void report(PrintStream ps) {
        String first = worker.getFirst();
        String last = worker.getLast();
        int id = worker.getId();
        double rate = worker.getPayRate();
        
        String report = String.format(
            "Payroll Reeeport%n" +
            "================%n" +
            "First: " + first + "%n" +
            "Last: " + last + "%n" +
            "Id: " + id + "%n" +
            "Rate: " + rate + "%n%n" +
            "%5S%5S%6S%7S%9S%n" + 
            "--------------------------------%n",
            "Month", "Day", "Year", "Hours", "Pay"
        );
        
        double totalHours = 0;
        double totalPay = 0;
        for (int i = 0; i < shifts.length; i++) {
            int day = shifts[i].getDate().getDay();
            int month = shifts[i].getDate().getMonth();
            int year = shifts[i].getDate().getYear();
            double hours = shifts[i].getHoursWorked();
            double pay = hours * rate;
            totalHours += hours;
            totalPay += pay;
            
            report += String.format(
                "%4d%5d%7d%7.2f%,9.2f%n",
                month, day, year, hours, pay
            );
        }
        report += String.format(
            "--------------------------------%n" + 
            "Total%18.2f %8.2f%n", totalHours, totalPay
        );
        
        ps.print(report);
    }
    
    /**
     * writeJSON, writes member values to given PrintStream in JSON format.
     * @author Julian Hecker
     * @since 11/1/2020
     * @param ps PrintStream 
     */
    public void writeJSON(PrintStream ps) {
        // Setting up GSON
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        // Convert this instance into json string
        String jsonString = gson.toJson(this);
        // Write json string to printstream
        ps.println(jsonString);
    }
    
    /**
     * readJSON, reads member values from given FileReader in JSON format
     * @author Julian Hecker
     * @since 11/4/2020
     * @param fr FileReader
     */
    public void readJSON(FileReader fr) {
        // Setting up GSON
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        // Convert JSON File's string to object
        TimeSheet jsonTimeSheet = gson.fromJson(fr, TimeSheet.class);        
        // Copy json data members to current instance
        this.shifts = jsonTimeSheet.shifts;
        this.worker = jsonTimeSheet.worker;
    }
    

    /**
     * toString Override, creates a string from the instance's members.
     * @author Julian Hecker
     * @since 11/1/2020
     * @return String
     */
    @Override
    public String toString() {
        String temp = String.format("%s%n", worker);
        for (Shift shift : shifts) {
            temp += String.format("%s", shift);
        }
        return temp;
    }
    
}
