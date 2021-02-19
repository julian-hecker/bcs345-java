package com.julianhecker.lablayouts;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LabApplication extends Application {
    /**
     * start, begins executing the UI code and loads main.fxml
     * @param primaryStage 
     */
    @Override
    public void start(Stage stage) {
        Parent root = null;
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anchorpane.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            System.err.println(ex);
            return;
        }
// Put the root containing the FXML into the scene
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
