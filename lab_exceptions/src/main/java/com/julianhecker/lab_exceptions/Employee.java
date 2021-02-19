/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianhecker.lab_exceptions;

/**
 *
 * @author hecker
 */
public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee() {
        this.name = "";
        this.id = -1;
        this.salary = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) throws BadIdException {
        if (id < 0 || id > 9999) {
            BadIdException bad = new BadIdException();
            bad.setId(id);
            throw bad;
        }
        this.id = id;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) throws BadSalaryException {
        if (salary < 0) {
            BadSalaryException bad = new BadSalaryException();
            bad.setSalary(salary);
            throw bad;
        }
        this.salary = salary;
    }
    
    
    
}
