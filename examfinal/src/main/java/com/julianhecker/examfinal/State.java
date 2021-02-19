package com.julianhecker.examfinal;

import com.google.gson.annotations.SerializedName;

public class State implements UsesConsole {
    @SerializedName ("name")
    private String state_name;
    @SerializedName ("capital")
    private String capital_name;
    @SerializedName("population")
    private int population;
    @SerializedName("revenue")
     int[] revenues;

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCapital_name() {
        return capital_name;
    }

    public void setCapital_name(String capital_name) {
        this.capital_name = capital_name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public void setRevenues(int[] revenues) {
        this.revenues = revenues;
    }
    
    @Override
    public void printToConsole() {
        System.out.printf("State: %s; Capital: %s; Population: %d; Revenues: ", state_name, capital_name, population);
        for (int i = 0; i < 4; i++) {
            System.out.print(revenues[i] + " ");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        return state_name.equals(((State) o).state_name);
    }
    
    @Override
    public String toString() {
        return String.format("%s, %s: Population: %d; Revenues: %d, %d, %d, %d", state_name, capital_name, population, revenues[0], revenues[1], revenues[2], revenues[3]);
    }
    
}
