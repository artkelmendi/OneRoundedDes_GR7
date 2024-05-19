package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class desroundController {

    @FXML
    private TextField leftHalfField;
    @FXML
    private TextField rightHalfField;
    @FXML
    private TextField subkeyField;
    @FXML
    private Text leftOutputText; // Changed to Text
    @FXML
    private Text rightOutputText; // Changed to Text
    @FXML
    private AnchorPane resultPane; // Result AnchorPane

    @FXML
    protected void computeDESRound() {
        // Read input values
        String L = leftHalfField.getText();
        String R = rightHalfField.getText();
        String K = subkeyField.getText();

        try {
            // Convert input strings to integers
            int leftHalf = Integer.parseUnsignedInt(L, 2);
            int rightHalf = Integer.parseUnsignedInt(R, 2);
            int subkey = Integer.parseUnsignedInt(K, 2);

            // Perform the f function (simplified for this example)
            int fOutput = fFunction(rightHalf, subkey);

            // Compute the new left and right halves
            int newLeft = rightHalf;
            int newRight = leftHalf ^ fOutput;

            // Convert results back to binary strings
            String newLeftStr = String.format("%32s", Integer.toBinaryString(newLeft)).replaceAll(" ", "0");
            String newRightStr = String.format("%32s", Integer.toBinaryString(newRight)).replaceAll(" ", "0");

            // Update the output labels
            leftOutputText.setText(newLeftStr);
            rightOutputText.setText(newRightStr);

            // Show the result pane
            resultPane.setVisible(true);
        } catch (NumberFormatException e) {
            // Handle invalid input
            leftHalfField.getStyleClass().add("invalid");
            rightHalfField.getStyleClass().add("invalid");
            subkeyField.getStyleClass().add("invalid");
            leftOutputText.setText("Invalid input");
            rightOutputText.setText("Invalid input");
            resultPane.setVisible(false);
        }
    }

    private int fFunction(int rightHalf, int subkey) {
        // Simplified f function for this example
        return rightHalf ^ subkey;
    }
}