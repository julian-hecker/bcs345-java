package com.julianhecker.classes2;

/**
 * Employee tracks name, hours worked, and rate.
 * @author Julian Hecker
 */
public class Employee {
    // Member Variables
    private String name;
    private double hoursWorked;
    private double hourlyRate;
    private double overtimeRate;
    // Getters
    /**
     * Gets Employee's name
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * Gets Employee's hours worked
     * @return double
     */
    public double getHours() {
        return hoursWorked;
    }
    /**
     * Gets Employee's pay rate
     * @return double
     */
    public double getRate() {
        return hourlyRate;
    }
    /**
     * Gets Employee's overtime rate
     * @return double
     */
    public double getOvertime() {
        return overtimeRate;
    }
    /**
     * Gets Employee's pay for the week
     * @return double
     */
    public double getPay() {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyRate;
        } else {
            return hoursWorked * hourlyRate + (hoursWorked - 40) * overtimeRate;
        }
    }
    // Setters
    /**
     * Sets Employee's Name
     * @param newName 
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * Sets Employee's hours worked
     * @param newHours 
     */
    public void setHours(double newHours) {
        hoursWorked = newHours;
    }
    /**
     * Sets Employee's pay rate
     * @param newRate 
     */
    public void setRate(double newRate) {
        hourlyRate = newRate;
    }
    /**
     * Sets Employee's overtime rate
     * @param newOvertime 
     */
    public void setOvertime(double newOvertime) {
        overtimeRate = newOvertime;
    }
    // Constructors
    /**
     * Initializes a new instance of Employee without parameters
     */
    public Employee() {
        name = "";
        hoursWorked = 0;
        hourlyRate = 0;
        overtimeRate = 0;
    }
    /**
     * Initializes a new instance of Employee with Parameters
     * @param newName
     * @param newHours
     * @param newRate 
     */
    public Employee(String newName, double newHours, double newRate) {
        name = newName;
        hoursWorked = newHours;
        hourlyRate = newRate;
        overtimeRate = newRate * 1.5;
    }
    // Methods
    /**
     * Generates a report of salaries
     */
    public void salaryReport() {
        System.out.printf("%-9s%-7s%-7s%-8s%n", "Pay", "Hours", "Rate", "Type");
        if (hoursWorked <= 40) {
            System.out.printf("%-9.2f%-7.2f%-7.2f%-8s%n", getPay(), hoursWorked, hourlyRate, "Normal");
        } else {
            System.out.printf("%-9.2f%-7.2f%-7.2f%-8s%n", 40.0 * hourlyRate, 40.0, hourlyRate, "Normal");
            System.out.printf("%-9.2f%-7.2f%-7.2f%-8s%n", (hoursWorked - 40) * overtimeRate, hoursWorked - 40, overtimeRate, "Overtime");
            System.out.printf("%-9.2f%-7s%n", hoursWorked * hourlyRate + (hoursWorked - 40) * overtimeRate, "Total");
        }
    }

    /**
     * Main Method
     * @param args 
     */
    public static void main(String[] args) {
        Employee salesman = new Employee("Reee", 55, 5.00);
        Employee ceo = new Employee("Ray", 15, 400.00);
        
        System.out.printf("Name: %s; Pay: %s%n", salesman.getName(), salesman.getPay());
        System.out.printf("Name: %s; Pay: %s%n", ceo.getName(), ceo.getPay());
        
        salesman.salaryReport();
        ceo.salaryReport();
    }
}
