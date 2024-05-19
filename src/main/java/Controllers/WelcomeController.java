package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import app.Navigator;

public class WelcomeController {
    @FXML
    private Button getStartedButton;

    @FXML
    private void handleGetStartedButtonClick(ActionEvent event) {
        // Navigate to the DES round page
        Navigator.navigate(event, Navigator.DES_ROUND_PAGE);
    }
}
