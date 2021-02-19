package com.julianhecker.examfinal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julianhecker.examfinal.State;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import javafx.stage.FileChooser.ExtensionFilter;

public class ExamController {

    private State state;

    @FXML
    private AnchorPane window;

    @FXML 
    private TextField field_state;
    @FXML
    private TextField field_capital;
    @FXML
    private TextField field_population;
    @FXML
    private TextField field_total;
    
    @FXML
    private ListView state_data;

    @FXML
    public void handle_menu_open(ActionEvent e) throws FileNotFoundException {
        // https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new ExtensionFilter("JSON Files", "*.json"),
                new ExtensionFilter("All Files", "*.*"));
        // https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
        File file = fc.showOpenDialog(window.getScene().getWindow());
        // Only read file if file was selected
        if (file != null) {
            // Create a filereader out of the file
            // https://www.techiedelight.com/read-text-file-using-filereader-java/
            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch (IOException err) {
                System.err.println(err);
                return;
            }
            // Setting up GSON
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            // Convert JSON File's string to object
            State jsonState = gson.fromJson(fr, State.class);
            state = jsonState;
            
            field_state.setText(state.getState_name());
            field_capital.setText(state.getCapital_name());
            field_population.setText(state.getPopulation() + "");
            int total = 0;
            for (int i = 0; i < 4; i++) {
                total += state.revenues[i];
            }
            field_total.setText(total + "");
            
            ObservableList<String> state_revenue = state_data.getItems();
            for (int i = 0; i < 4; i++) {
                state_revenue.add(state.revenues[i] + "");
            }

        } else {
            System.out.println("Did not select file");
        }
    }

    @FXML
    public void handle_menu_save(ActionEvent e) {
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(window.getScene().getWindow());
        // Only execute if file chosen
        if (file != null) {
            PrintStream ps = null;
            try {
                ps = new PrintStream(file);
            } catch (FileNotFoundException err) {
                System.err.println(err);
                return;
            }
            // Copy UI data to state instance
            state.setState_name(field_state.getText());
            state.setCapital_name(field_capital.getText());
            state.setPopulation(Integer.parseInt(field_population.getText()));
            
            // Write JSON to the chosen file
            // Setting up GSON
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            // Convert this instance into json string
            String jsonString = gson.toJson(state);
            // Write json string to printstream
            ps.println(jsonString);

        } else {
            System.out.println("Did not select file");
        }
    }
    
    @FXML
    public void handle_menu_exit (ActionEvent e) {
        System.exit(0);
    }
}
