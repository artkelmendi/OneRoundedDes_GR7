 #  ONE-ROUND DES Alogorithm
 
 # University Details 
- University: University of Prishtina "Hasan Prishtina"
- Faculty: Faculty of Electrical and Computer Enigneering 
- Department: Computer and Software Engineering 
- Course: Data Security 
- Semester: 4th Semester

# Supervisors
- Professor: Blerim Rexha 
- Assistent: Mergim Hoti


 
# Contributors
- [Art Kelmendi](<https://github.com/artkelmendi>)
- [Art Jashari](<https://github.com/Art-Jashari>)
- [Artin Rexhepi](<https://github.com/artin-rexhepi>)
- [Armenie Sadikaj](<https://github.com/armeniasadikaj>)

# DES Round Simulator

## Overview
The DES Round Simulator is a JavaFX-based application designed to simulate a single round of the Data Encryption Standard (DES) algorithm. It provides a graphical user interface for users to input the left half, right half, and subkey, and then compute the results of the DES round function.

## Features
- **Graphical User Interface**: Easy-to-use interface for input and output of DES round values.
- **Input Validation**: Ensures that the inputs for the left half, right half, and subkey meet the required bit lengths.
- **DES Round Computation**: Simulates the expansion, substitution, and permutation steps of a DES round.

## Project Structure
The project consists of the following main components:
- `app`: Contains the main application entry point and the navigator for switching between scenes.
- `Controllers`: Contains the controllers for handling user interactions and logic for the DES round and welcome page.

## Installation
To set up and run the project locally, follow these steps:

1. **Clone the Repository**:
    ```sh
    git clone <repository-url>
    cd des-round-simulator
    ```

2. **Open in IDE**: Open the project in an IDE that supports Java and JavaFX (e.g., IntelliJ IDEA or Eclipse).

3. **Add JavaFX Library**: Ensure that your IDE is configured with the JavaFX library. You can download it from the [official website](https://openjfx.io/).

4. **Run the Application**:
- Locate the `main` class in the `app` package.
- Run the `main` class.

## Usage
1. **Start the Application**: Launch the application, and you will be presented with the welcome page.
2. **Navigate to DES Round Page**: Click the "Start" button to navigate to the DES round input page.
3. **Enter Inputs**: Provide the left half (32 bits), right half (32 bits), and subkey (48 bits) in the respective fields.
4. **Compute DES Round**: Click the "Compute" button to perform the DES round computation. The results will be displayed on the screen.

## Code Details

### Main Application (`main.java`)
The entry point of the application, responsible for launching the JavaFX application and initializing the welcome page.

```java
package app;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Navigator.navigate(stage, Navigator.WELCOMING_PAGE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}