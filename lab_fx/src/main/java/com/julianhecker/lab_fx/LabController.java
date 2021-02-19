package com.julianhecker.lab_fx;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.*;


/**
 * FX Lab Controller
 * @author Julian Hecker
 */
public class LabController {
    @FXML
    private AnchorPane window;
    
    @FXML
    private ListView dataList;
    @FXML
    private Button dataButton;
    
    @FXML
    public void handleDataButtonAction(ActionEvent event) {
        ObservableList<String> data = dataList.getItems();
        data.add("Reee");
    }

    
}

class old {
    @FXML
    private AnchorPane window;

    @FXML
    private Button redButton;
    @FXML
    private Button greenButton;
    @FXML
    private Button blueButton;
    
    @FXML
    private MenuItem redMenu;
    @FXML 
    private MenuItem greenMenu;
    @FXML
    private MenuItem blueMenu;
    
    @FXML
    public void handleRedAction(ActionEvent event) {
        System.out.println("Red");
        window.setStyle("-fx-background-color: #FF0000;");
    }
    @FXML
    public void handleGreenAction(ActionEvent event) {
        System.out.println("Green");
        window.setStyle("-fx-background-color: #00FF00;");
    }
    @FXML
    public void handleBlueAction(ActionEvent event) {
        System.out.println("Blue");
        window.setStyle("-fx-background-color: #0000FF;");
    }
}
