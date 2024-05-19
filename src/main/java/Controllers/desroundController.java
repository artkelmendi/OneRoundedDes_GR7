package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;

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
    private Pane leftErrorPane;
    @FXML
    private Text leftErrorText;

    @FXML
    private Pane rightErrorPane;
    @FXML
    private Text rightErrorText;

    @FXML
    private Pane subkeyErrorPane;
    @FXML
    private Text subkeyErrorText;

    private final int[] E = {
            32,  1,  2,  3,  4,  5,  4,  5,
            6,  7,  8,  9,  8,  9, 10, 11,
            12, 13, 12, 13, 14, 15, 16, 17,
            16, 17, 18, 19, 20, 21, 20, 21,
            22, 23, 24, 25, 24, 25, 26, 27,
            28, 29, 28, 29, 30, 31, 32,  1
    };

    private final int[][] S = {
            {
                    14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7,
                    0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8,
                    4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0,
                    15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6, 13
            },
            {
                    15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10,
                    3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5,
                    0, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15,
                    13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9
            },
            {
                    10,  0,  9, 14,  6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8,
                    13,  7,  0,  9,  3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1,
                    13,  6,  4,  9,  8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7,
                    1, 10, 13,  0,  6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12
            },
            {
                    7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15,
                    13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9,
                    10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4,
                    3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14
            },
            {
                    2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9,
                    14, 11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6,
                    4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14,
                    11,  8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3
            },
            {
                    12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11,
                    10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8,
                    9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6,
                    4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13
            },
            {
                    4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1,
                    13,  0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6,
                    1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2,
                    6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12
            },
            {
                    13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7,
                    1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2,
                    7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8,
                    2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11
            }
    };

    private final int[] P = {
            16,  7, 20, 21,
            29, 12, 28, 17,
            1, 15, 23, 26,
            5, 18, 31, 10,
            2,  8, 24, 14,
            32, 27,  3,  9,
            19, 13, 30,  6,
            22, 11,  4, 25
    };

    @FXML
    protected void computeDESRound() {
        leftHalfField.getStyleClass().remove("invalid");
        rightHalfField.getStyleClass().remove("invalid");
        subkeyField.getStyleClass().remove("invalid");
        leftErrorPane.setVisible(false);
        rightErrorPane.setVisible(false);
        subkeyErrorPane.setVisible(false);

        String L = leftHalfField.getText();
        String R = rightHalfField.getText();
        String K = subkeyField.getText();

        boolean hasError = false;
        if (L.length() != 32 || !isBinary(L)) {
            leftHalfField.getStyleClass().add("invalid");
            leftErrorText.setText("Left half must be a 32-bit binary value.");
            leftErrorPane.setVisible(true);
            hasError = true;
        }
        if (R.length() != 32 || !isBinary(R)) {
            rightHalfField.getStyleClass().add("invalid");
            rightErrorText.setText("Right half must be a 32-bit binary value.");
            rightErrorPane.setVisible(true);
            hasError = true;
        }
        if (K.length() != 48 || !isBinary(K)) {
            subkeyField.getStyleClass().add("invalid");
            subkeyErrorText.setText("Subkey must be a 48-bit binary value.");
            subkeyErrorPane.setVisible(true);
            hasError = true;
        }
        if (hasError) {
            resultPane.setVisible(false);
            return;
        }

        try {
            int leftHalf = Integer.parseUnsignedInt(L, 2);
            int rightHalf = Integer.parseUnsignedInt(R, 2);
            long subkey = Long.parseUnsignedLong(K, 2);

            int fOutput = fFunction(rightHalf, subkey);

            int newLeft = rightHalf;
            int newRight = leftHalf ^ fOutput;

            String newLeftStr = String.format("%32s", Integer.toBinaryString(newLeft)).replace(' ', '0');
            String newRightStr = String.format("%32s", Integer.toBinaryString(newRight)).replace(' ', '0');

            leftOutputText.setText(newLeftStr);
            rightOutputText.setText(newRightStr);

            resultPane.setVisible(true);
        } catch (NumberFormatException e) {
            leftHalfField.getStyleClass().add("invalid");
            rightHalfField.getStyleClass().add("invalid");
            subkeyField.getStyleClass().add("invalid");
            leftErrorText.setText("Invalid input format.");
            rightErrorText.setText("Invalid input format.");
            subkeyErrorText.setText("Invalid input format.");
            leftErrorPane.setVisible(true);
            rightErrorPane.setVisible(true);
            subkeyErrorPane.setVisible(true);
            resultPane.setVisible(false);
        }
    }

    private boolean isBinary(String input) {
        return input.matches("[01]+");
    }

    private int fFunction(int rightHalf, long subkey) {
        long expandedRightHalf = expand(rightHalf);
        System.out.println("Expanded Right Half: " + Long.toBinaryString(expandedRightHalf));

        long xorOutput = expandedRightHalf ^ subkey;
        System.out.println("XOR Output: " + Long.toBinaryString(xorOutput));

        int sBoxOutput = sBoxSubstitution(xorOutput);
        System.out.println("S-Box Output: " + Integer.toBinaryString(sBoxOutput));

        int permutedOutput = permute(sBoxOutput);
        System.out.println("Permuted Output: " + Integer.toBinaryString(permutedOutput));

        return permutedOutput;
    }

    private long expand(int rightHalf) {
        long expanded = 0;
        for (int i = 0; i < E.length; i++) {
            expanded <<= 1;
            expanded |= (rightHalf >> (32 - E[i])) & 1;
        }
        System.out.println("Expanded Right Half: " + Long.toBinaryString(expanded));
        return expanded;
    }

    private int sBoxSubstitution(long input) {
        int output = 0;
        for (int i = 0; i < 8; i++) {
            int sixBits = (int) ((input >> (42 - 6 * i)) & 0x3F);
            int row = ((sixBits >> 5) << 1) | (sixBits & 1);
            int col = (sixBits >> 1) & 0xF;
            output <<= 4;
            output |= S[i][row * 16 + col];
        }
        System.out.println("S-Box Output: " + Integer.toBinaryString(output));
        return output;
    }

    private int permute(int input) {
        int output = 0;
        for (int i = 0; i < P.length; i++) {
            output <<= 1;
            output |= (input >> (32 - P[i])) & 1;
        }
        System.out.println("Permuted Output: " + Integer.toBinaryString(output));
        return output;
    }
}
