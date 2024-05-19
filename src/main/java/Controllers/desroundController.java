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

            // Perform DES round
            int newLeft = rightHalf;
            int newRight = leftHalf ^ fFunction(rightHalf, subkey);

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
        // Expansion (E) table
        int[] E = {
                32, 1, 2, 3, 4, 5,
                4, 5, 6, 7, 8, 9,
                8, 9, 10, 11, 12, 13,
                12, 13, 14, 15, 16, 17,
                16, 17, 18, 19, 20, 21,
                20, 21, 22, 23, 24, 25,
                24, 25, 26, 27, 28, 29,
                28, 29, 30, 31, 32, 1
        };

        // Substitution (S-box) tables
        int[][][] S = {
                // S1
                {
                        {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                        {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                        {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                        {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
                },
                // S2
                {
                        {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                        {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                        {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                        {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
                },
                // S3
                {
                        {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                        {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                        {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                        {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
                },
                // S4
                {
                        {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                        {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                        {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                        {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
                },
                // S5
                {
                        {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                        {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                        {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                        {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
                },
                // S6
                {
                        {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                        {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                        {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                        {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
                },
                // S7
                {
                        {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                        {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                        {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                        {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
                },
                // S8
                {
                        {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                        {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                        {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                        {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
                }
        };

        // Permutation (P) table
        int[] P = {
                16, 7, 20, 21,
                29, 12, 28, 17,
                1, 15, 23, 26,
                5, 18, 31, 10,
                2, 8, 24, 14,
                32, 27, 3, 9,
                19, 13, 30, 6,
                22, 11, 4, 25
        };

        // Expand rightHalf from 32 to 48 bits
        long expandedRightHalf = 0;
        for (int i = 0; i < 48; i++) {
            expandedRightHalf |= ((rightHalf >> (32 - E[i])) & 0x1) << (47 - i);
        }

        // XOR with subkey
        long xorWithSubkey = expandedRightHalf ^ subkey;

        // Apply S-boxes
        int sBoxOutput = 0;
        for (int i = 0; i < 8; i++) {
            int row = ((int) ((xorWithSubkey >> (42 - 6 * i)) & 0x20) >> 4) | ((int) (xorWithSubkey >> (42 - 6 * i)) & 0x1);
            int col = (int) (xorWithSubkey >> (43 - 6 * i)) & 0x1E;
            sBoxOutput |= S[i][row][col] << (28 - 4 * i);
        }

        // Permutation
        int fOutput = 0;
        for (int i = 0; i < 32; i++) {
            fOutput |= ((sBoxOutput >> (32 - P[i])) & 0x1) << (31 - i);
        }

        return fOutput;
    }
}
