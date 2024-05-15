package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("/app/desround.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
        scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
        stage.setTitle("DES Round");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
