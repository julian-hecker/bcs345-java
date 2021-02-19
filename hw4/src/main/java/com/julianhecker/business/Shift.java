package com.julianhecker.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.FileReader;
import java.io.PrintStream;

/**
 * Shift: Keeps track of a single shift (Date + hours)
 * @author Julian Hecker
 */
public class Shift {
    // Private Members
    @SerializedName("date")
    private MyDate date;
    @SerializedName("hoursWorked")
    private double hoursWorked;

    // Constructors
    /**
     * Default Constructor: Sets an empty shift
     */
    public Shift() {
        date = new MyDate(); // Calls MyDate's default constructor
        hoursWorked = 0;
    }
    /**
     * Create a shift from given data
     * @param newDate
     * @param newHoursWorked 
     */
    public Shift(MyDate newDate, double newHoursWorked) {
        date = newDate;
        hoursWorked = newHoursWorked;
    }
    
    // Getters
    /**
     * getDate: Gets shift's date
     * @return date
     */
    public MyDate getDate() {
        return date;
    }
    /**
     * getHoursWorked: gets shift's duration
     * @return hoursWorked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    // Setters
    /**
     * setDate: sets shift's date
     * @param date 
     */
    public void setDate(MyDate date) {
        this.date = date;
    }
    /**
     * setHoursWorked: set shift's duration
     * @param hoursWorked 
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    // Methods
    /**
     * readJSON: Reads Worker info from given FileReader
     * @param fr 
     */
    public void readJson(FileReader fr) {
        // Setting up GSON
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        // Convert JSON File's string to object
        Shift jsonShift = gson.fromJson(fr, Shift.class);
        // Copy json data members to current instance
        this.setDate(jsonShift.getDate());
        this.setHoursWorked(jsonShift.getHoursWorked());
    }
    /**
     * writeJSON: Writes Worker info into given printStream
     * @param ps 
     */
    public void writeJson(PrintStream ps) {
        // Setting up GSON
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        // Convert this instance into json string
        String jsonString = gson.toJson(this);
        // Write json string to printstream
        ps.println(jsonString);
    }
    
    // Overrides
    /**
     * toString Method Override
     * @return string shift
     */
    @Override
    public String toString() {
        return String.format("%s: %shrs", date, hoursWorked);
    }
}
