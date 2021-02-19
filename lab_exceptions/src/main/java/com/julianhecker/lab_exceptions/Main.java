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
public class Main {
    public static void main(String argsp[]) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        
        try {
            e1.setId(0);
            e1.setSalary(123333);
            e2.setId(9999);
            e2.setSalary(0.5);
        } catch (BadIdException err) {
            System.out.println("There was a BadIdException. Id's must fall between 0 and 9999.");
        } catch (BadSalaryException err) {
            System.out.println("There was a BadSalaryException. Salaries must be 0 or greater.");
        }
        System.out.println("Catches done!");
    }
}
