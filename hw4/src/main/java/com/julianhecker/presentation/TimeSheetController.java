package com.julianhecker.presentation;

import com.julianhecker.business.TimeSheet;
import com.julianhecker.business.Worker;

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

/**
 * Time Sheet Controller, controls the FXML User Interface
 *
 * @author Julian Hecker
 * @since 11/25/2020
 */
public class TimeSheetController {
    private TimeSheet ts = new TimeSheet(); // Or else big NullPointerException
    
    @FXML
    private AnchorPane window;

    @FXML
    private TextField workerFirstName;
    @FXML
    private TextField workerLastName;
    @FXML
    private TextField workerId;
    @FXML
    private TextField workerPayRate;

    @FXML
    private ListView shiftData;

    /**
     * handleOpen, runs each time a file is selected and opened
     * @param e ActionEvent
     * @throws FileNotFoundException if file is not found
     */
    @FXML
    public void handleOpen(ActionEvent e) throws FileNotFoundException {
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
            // Pass FileReader into readJSON
            ts.readJSON(fr);
            
            // Put data into Listview
            Worker w = ts.getWorker();
            workerFirstName.setText(w.getFirst());
            workerLastName.setText(w.getLast());
            workerId.setText("" + w.getId());
            workerPayRate.setText("" + w.getPayRate());
            
            
            ObservableList<String> shifts = shiftData.getItems();
            // Iterate over TimeSheet Shifts
            int i = 0;
            while (true) {
                try {
                    shifts.add(ts.getAt(i).toString());
                } catch (ArrayIndexOutOfBoundsException err) {
                    // Catching the exception we defined
                    break;
                }
                i++;
            }
            
        } else {
            System.out.println("Did not select file");
        }
    }

    /**
     * handleSaveAs, runs each time Save As is selected.
     *
     * @param e ActionEvent
     */
    @FXML
    public void handleSaveAs(ActionEvent e) {
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
            // Write JSON to the chosen file
            ts.writeJSON(ps);

        } else {
            System.out.println("Did not select file");
        }
    }

    /**
     * handleSaveReport, runs each time Save Report is selected. Saves to file.
     *
     * @param e ActionEvent
     */
    @FXML
    public void handleSaveReport(ActionEvent e) {
        FileChooser fc = new FileChooser();
        File file = fc.showSaveDialog(window.getScene().getWindow());
        // Only execute if file chosen
        if (file != null) {
            PrintStream ps = null;
            try {
                ps = new PrintStream(file);
            } catch (FileNotFoundException err) {
                System.err.println(err);
                return;
            }
            // Save a report to chosen file
            ts.report(ps);
            
        } else {
            System.out.println("Did not select file");
        }
        
        
    }

    /**
     * handleExit, runs if user chooses to exit program. Stops program.
     *
     * @param e ActionEvent
     */
    @FXML
    public void handleExit(ActionEvent e) {
        System.exit(0); // Nice and easy
    }

}
