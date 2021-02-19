package com.julianhecker.presentation;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Time Sheet Application, runs the FXML code
 * @author Julian Hecker
 * @since 11/25/2020
 */
public class TimeSheetApplication extends Application {
    /**
     * start, begins executing the UI code and loads main.fxml
     * @param primaryStage 
     */
    @Override
    public void start(Stage stage) {
        Parent root = null;
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            System.err.println(ex);
            return;
        }
// Put the root containing the FXML into the scene
        scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("TimeSheet GUI App");
        stage.show();
    }
}
