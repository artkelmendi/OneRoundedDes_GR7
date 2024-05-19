package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
public class welcomeController {
    @FXML
    private Button startButton;

    @FXML
    protected void startApplication() {
        try {
            // Load main page
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app/desround.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) startButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("DES Round");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void initialize() {
        // Initialize method (optional)
    }

}
