package com.julianhecker.examfinal;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExamApplication extends Application {
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
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
