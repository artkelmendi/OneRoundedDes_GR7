package Controllers;

import javafx.fxml.FXML;
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
    private Text leftOutputText;
    @FXML
    private Text rightOutputText;
    @FXML
    private AnchorPane resultPane;

    @FXML
    protected void computeDESRound() {
        // Reset styles and messages
        leftHalfField.getStyleClass().remove("invalid");
        rightHalfField.getStyleClass().remove("invalid");
        subkeyField.getStyleClass().remove("invalid");
        leftOutputText.setText("");
        rightOutputText.setText("");

        // Read input values
        String L = leftHalfField.getText();
        String R = rightHalfField.getText();
        String K = subkeyField.getText();

        boolean validInput = true;

        // Validate input lengths
        if (L.length() != 32) {
            leftHalfField.getStyleClass().add("invalid");
            leftOutputText.setText("Left Half (L) must be 32 bits");
            validInput = false;
        }
        if (R.length() != 32) {
            rightHalfField.getStyleClass().add("invalid");
            rightOutputText.setText("Right Half (R) must be 32 bits");
            validInput = false;
        }
        if (K.length() != 48) {
            subkeyField.getStyleClass().add("invalid");
            leftOutputText.setText("Subkey (K) must be 48 bits");
            rightOutputText.setText("Subkey (K) must be 48 bits");
            validInput = false;
        }

        if (!validInput) {
            resultPane.setVisible(false);
            return;
        }

        try {
            // Convert input strings to integers
            int leftHalf = Integer.parseUnsignedInt(L, 2);
            int rightHalf = Integer.parseUnsignedInt(R, 2);
            long subkey = Long.parseUnsignedLong(K, 2); // Use long for 48-bit subkey

            // Perform the f function (simplified for this example)
            int fOutput = fFunction(rightHalf, subkey);

            // Compute the new left and right halves
            int newLeft = rightHalf;
            int newRight = leftHalf ^ fOutput;

            // Convert results back to 32-bit binary strings
            String newLeftStr = String.format("%32s", Integer.toBinaryString(newLeft)).replace(' ', '0');
            String newRightStr = String.format("%32s", Integer.toBinaryString(newRight)).replace(' ', '0');

            // Update the output texts
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

    private int fFunction(int rightHalf, long subkey) {
        // Simplified f function for this example
        return (int) (rightHalf ^ (int) subkey);
    }
}
