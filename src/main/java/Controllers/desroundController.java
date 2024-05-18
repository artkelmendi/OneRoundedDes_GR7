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
        clearStyles();

        String L = leftHalfField.getText();
        String R = rightHalfField.getText();
        String K = subkeyField.getText();

        System.out.println("L: " + L);
        System.out.println("R: " + R);
        System.out.println("K: " + K);

        try {
            if (L.length() != 32 || R.length() != 32 || K.length() != 48) {
                throw new NumberFormatException("Invalid length");
            }

            int leftHalf = Integer.parseUnsignedInt(L, 2);
            int rightHalf = Integer.parseUnsignedInt(R, 2);
            int subkey = Integer.parseUnsignedInt(K, 2);

            System.out.println("Parsed leftHalf: " + leftHalf);
            System.out.println("Parsed rightHalf: " + rightHalf);
            System.out.println("Parsed subkey: " + subkey);

            int fOutput = fFunction(rightHalf, subkey);

            System.out.println("fFunction output: " + fOutput);

            int newLeft = rightHalf;
            int newRight = leftHalf ^ fOutput;

            String newLeftStr = String.format("%32s", Integer.toBinaryString(newLeft)).replace(' ', '0');
            String newRightStr = String.format("%32s", Integer.toBinaryString(newRight)).replace(' ', '0');

            System.out.println("newLeftStr: " + newLeftStr);
            System.out.println("newRightStr: " + newRightStr);

            // Update UI components
            leftOutputText.setText(newLeftStr);
            rightOutputText.setText(newRightStr);

            System.out.println("leftOutputText set to: " + newLeftStr);
            System.out.println("rightOutputText set to: " + newRightStr);

            resultPane.setVisible(true);

            System.out.println("resultPane set to visible");

        } catch (NumberFormatException e) {
            handleInvalidInput();
        }
    }

    private void clearStyles() {
        leftHalfField.getStyleClass().remove("invalid");
        rightHalfField.getStyleClass().remove("invalid");
        subkeyField.getStyleClass().remove("invalid");
        leftOutputText.setText("");
        rightOutputText.setText("");
    }

    private void handleInvalidInput() {
        leftHalfField.getStyleClass().add("invalid");
        rightHalfField.getStyleClass().add("invalid");
        subkeyField.getStyleClass().add("invalid");
        leftOutputText.setText("Invalid input");
        rightOutputText.setText("Invalid input");
        resultPane.setVisible(false);
    }

    private int fFunction(int rightHalf, int subkey) {
        return rightHalf ^ subkey;
    }
}
