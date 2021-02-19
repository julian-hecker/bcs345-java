package com.julianhecker.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.FileReader;
import java.io.PrintStream;

/**
 * MyDate: Keeps track of a single date (day, month, year)
 * @author Julian Hecker
 */
public class MyDate {
    // Member Variables
    @SerializedName("day")
    private int day;
    @SerializedName("month")
    private int month;
    @SerializedName("year")
    private int year;
    
    // Constructors
    /**
     * Default Constructor: Takes no parameters and creates a date at 12/31/1999
     * Just in time for Y2K :)
     * @author Julian Hecker
     */
    public MyDate() {
        day = 31;
        month = 12;
        year = 1999;
    }
    /**
     * Parameter Constructor: Constructs a new date from given day, month, and year.
     * @param newDay
     * @param newMonth
     * @param newYear 
     */
    public MyDate(int newDay, int newMonth, int newYear) {
        day = newDay;
        month = newMonth;
        year = newYear;
    }
    
    // Getters
    /**
     * Gets the date's day value.
     * @return day
     */
    public int getDay() {
        return day;
    }
    /**
     * Gets the date's month value
     * @return month
     */
    public int getMonth() {
        return month;
    }
    /**
     * Gets the date's year value
     * @return year
     */
    public int getYear() {
        return year;
    }
    
    // Setters
    /**
     * Sets the date's day value
     * @param newDay 
     */
    public void setDay(int newDay) {
        day = newDay;
    }
    /**
     * Sets the date's month value
     * @param newMonth 
     */
    public void setMonth(int newMonth) {
        month = newMonth;
    }
    /**
     * Sets the date's year value
     * @param newYear 
     */
    public void getYear(int newYear) {
        year = newYear;
    }
           
    // Methods
    /**
     * readJSON: Reads date info from given FileReader
     * @param fr 
     */
    public void readJson(FileReader fr) {
        // Setting up GSON
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        // Convert JSON File's string to object
        MyDate jsonDate = gson.fromJson(fr, MyDate.class);
        // Copy json data members to current instance
        day = jsonDate.getDay();
        month = jsonDate.getMonth();
        year = jsonDate.getYear();
    }
    /**
     * writeJSON: Writes date info into given printStream
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
     * @return string date
     */
    @Override
    public String toString() {
        return String.format("%s/%s/%s", month, day, year);
    }
}
