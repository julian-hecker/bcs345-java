package com.julianhecker.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.FileReader;
import java.io.PrintStream;

/**
 * Worker: Keeps track of a single employee
 * @author Julian Hecker
 */
public class Worker {
    // Private Members
    @SerializedName("first")
    private String first;
    @SerializedName("last")
    private String last;
    @SerializedName("id")
    private int id;
    @SerializedName("payRate")
    private double payRate;

    // Constructors
    /**
     * Default Constructor, initializes a worker without name, id, or pay
     */
    public Worker() {
        first = "N/a";
        last = "N/a";
        id = -1;
        payRate = 0.00;
    }
    /**
     * Constructor, initializes all fields of a worker using given data.
     * @param newFirst
     * @param newLast
     * @param newId
     * @param newPayRate 
     */
    public Worker(String newFirst, String newLast, int newId, double newPayRate) {
        first = newFirst;
        last = newLast;
        id = newId;
        payRate = newPayRate;
    }

    // Getters
    /**
     * getFirst: Gets worker's first name
     * @return first
     */
    public String getFirst() {
        return first;
    }
    /**
     * getLast: Gets worker's last name
     * @return last
     */
    public String getLast() {
        return last;
    }
    /**
     * getId: Gets worker's id
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * getPayRate: Gets worker's pay rate
     * @return 
     */
    public double getPayRate() {
        return payRate;
    }
    
    // Setters
    /**
     * setFirst: Sets worker's first name
     * @param first 
     */
    public void setFirst(String first) {
        this.first = first;
    }
    /**
     * setLast: Sets worker's last name
     * @param last 
     */
    public void setLast(String last) {
        this.last = last;
    }
    /**
     * setId: Sets worker's id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * setPayRate: Sets worker's pay rate
     * @param payRate 
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
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
        Worker jsonWorker = gson.fromJson(fr, Worker.class);
        // Copy json data members to current instance
        first = jsonWorker.getFirst();
        last = jsonWorker.getLast();
        id = jsonWorker.getId();
        payRate = jsonWorker.getPayRate();
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
     * @return string Worker
     */
    @Override
    public String toString() {
        return String.format("%s: %s %s | $%s/hr", id, first, last, payRate);
    }
}
