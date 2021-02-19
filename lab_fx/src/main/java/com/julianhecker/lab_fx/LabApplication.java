/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianhecker.lab_fx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hecker
 */
public class LabApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tabpane.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
// Put the root containing the FXML into the scene
        scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
