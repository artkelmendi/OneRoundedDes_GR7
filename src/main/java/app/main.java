package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Load Welcome Page initially
        Parent root = FXMLLoader.load(getClass().getResource("/app/welcome.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Welcome to DES Round");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
