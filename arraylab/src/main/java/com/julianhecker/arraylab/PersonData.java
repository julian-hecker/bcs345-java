/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianhecker.arraylab;

/**
 *
 * @author hecker
 */
public class PersonData {
    private Person[] people = new Person[5];
    
    Person get(int index) {
        return people[index];
    }
    
    void set(int index, Person p) {
        people[index] = p;
    }
    
    void display() {
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }
    
    public PersonData() {
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setName("NONAME");
            people[i] = person;
        }
    }
}
