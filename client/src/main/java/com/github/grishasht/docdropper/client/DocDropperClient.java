package com.github.grishasht.docdropper.client;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DocDropperClient extends Application {


    private static final String PATH_FXML = "client/src/main/java/com/github/grishasht/docdropper/client/main.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        URL url = new File(PATH_FXML).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root, 944, 700);

        stage.setTitle("Document Dropper");
        stage.setScene(scene);
        stage.show();
    }

}