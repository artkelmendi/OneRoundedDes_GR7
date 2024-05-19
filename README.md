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

# Structure of ONE-ROUND DES
The Data Encryption Standard (DES) is a symmetric-key block cipher that encrypts data in 64-bit blocks using a 56-bit key. 
One round of DES is a single iteration of its core encryption process, and DES consists of 16 such rounds. Each round enhances the security of the encryption.

# One Round of DES:

- Input: A 64-bit data block divided into two 32-bit halves (Left and Right) and a 48-bit subkey.
- Process:
- Expansion: The 32-bit Right half is expanded to 48 bits.
- Key Mixing: The expanded Right half is XORed with the subkey.
- Substitution: The result is passed through S-boxes, reducing it back to 32 bits.
- Permutation: The 32-bit output is permuted.
- Combination: The permuted result is XORed with the Left half.
- Output: The new Right half is the original Left half, and the new Left half is the result of the XOR operation.
This one-round process is repeated 16 times in DES to achieve robust encryption.

# Requirements
- Java 11+: Ensure Java 11 or later is installed. 
- JavaFX: Include JavaFX libraries in your project. 
- Scene Builder: Use Scene Builder for designing the GUI.

# How To Run
- Clone the Repository 
- git clone <repository-url>
cd <repository-directory>
- Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse). 
- Run the Application 
- Run the main.java file to start the application.

# How It Works
- Input Key  
- Enter Key: Input the key (k) for encryption and decryption. 
- Text Input 
- Enter Plaintext or Ciphertext: Input the text to be encrypted or decrypted.
- Encryption 
- Encrypt Button: Encrypt the input text using the provided key.
- Decryption 
- Decrypt Button: Decrypt the input text using the same key.

# Project Description
- This JavaFX application simulates the one-round DES (Data Encryption Standard) algorithm. The project consists of two main parts:

A welcoming page that introduces users to the application.
An interactive simulation page where users can input values and observe the encryption process.

# Usage
- Welcome Page 
- The welcome page provides an introduction to the One-Round DES Algorithm. 
- Click the "Get Started" button to navigate to the DES round simulation page. 
- DES Round Simulation Page 
- Enter the left half (L), right half (R), and subkey (K) in binary format. 
- Click the "Compute" button to perform the one-round DES computation. 
- The result (new left and right halves) will be displayed on the screen.

# Example Usage
- Input
- Key: Enter a key (48-bit subkey). 
- Text: Enter the plaintext (32-bit left half and 32-bit right half). 
- Output 
- Encrypted Text: Display the encrypted text. 
- Decrypted Text: Display the decrypted text.
 # Notes
 - Security: One-round DES is not secure for real-world applications; it's meant for educational purposes.
- User-Friendly Interface: The GUI simplifies the encryption and decryption tasks.
- Error Handling: The application handles various user errors gracefully.
 # Expected Outcomes
- Educational Value: Understand the basic operations of DES.
- Usability: The application is designed to be intuitive and easy to use.
- Error Resilience: Built-in error handling ensures reliable operation.
