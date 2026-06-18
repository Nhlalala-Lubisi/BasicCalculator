Basic Calculator
A simple Java console application that performs basic arithmetic operations: addition, subtraction, multiplication, and division.

Features
Addition, subtraction, multiplication, and division
Handles division by zero gracefully
Input validation for non-numeric entries
Clean, formatted console output
Project Structure
BasicCalculator/
├── pom.xml
└── src/
    ├── main/java/
    │   ├── Calculator.java       # Arithmetic logic
    │   └── Main.java             # Console UI and input loop
    └── test/java/
        └── CalculatorTest.java   # JUnit 5 unit tests
Requirements
Java 17+
Maven 3.6+
Getting Started
Clone or download the project, then build:
mvn package
Run the JAR:
java -jar target/BasicCalculator.jar
Or run directly in IntelliJ:
Right-click Main.java → Run 'Main.main()'

Usage

Select an operation:
  1. Addition       (+)
  2. Subtraction    (-)
  3. Multiplication (×)
  4. Division       (÷)
  5. Exit

Enter choice (1-5): 1
Enter first number:  10
Enter second number: 5

  10 + 5 = 15
Running Tests
mvn test
The test suite covers:

Addition with positives, negatives, and zeros
Subtraction resulting in positive and negative values
Multiplication including zero and two negatives
Division including decimals and divide-by-zero exception
Error Handling
Scenario	Behaviour
Division by zero	Prints an error message, continues running
Non-numeric input	Prompts the user to re-enter a valid number
Invalid menu choice	Prompts the user to select a valid option (1–5)
Built With
Java 21
Maven
JUnit Jupiter 5.10.2
