import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // Addition

    @Test
    @DisplayName("Add two positive numbers")
    void testAddPositives() {
        assertEquals(10.0, calculator.add(3, 7));
    }

    @Test
    @DisplayName("Add positive and negative number")
    void testAddNegative() {
        assertEquals(-2.0, calculator.add(3, -5));
    }

    @Test
    @DisplayName("Add two zeros")
    void testAddZeros() {
        assertEquals(0.0, calculator.add(0, 0));
    }

    // Subtraction

    @Test
    @DisplayName("Subtract smaller from larger")
    void testSubtractPositive() {
        assertEquals(5.0, calculator.subtract(10, 5));
    }

    @Test
    @DisplayName("Subtract resulting in negative")
    void testSubtractResultNegative() {
        assertEquals(-3.0, calculator.subtract(2, 5));
    }

    // Multiplication

    @Test
    @DisplayName("Multiply two positive numbers")
    void testMultiplyPositives() {
        assertEquals(12.0, calculator.multiply(3, 4));
    }

    @Test
    @DisplayName("Multiply by zero")
    void testMultiplyByZero() {
        assertEquals(0.0, calculator.multiply(999, 0));
    }

    @Test
    @DisplayName("Multiply two negatives gives positive")
    void testMultiplyNegatives() {
        assertEquals(6.0, calculator.multiply(-2, -3));
    }

    // Division

    @Test
    @DisplayName("Divide two positive numbers")
    void testDividePositives() {
        assertEquals(4.0, calculator.divide(20, 5));
    }

    @Test
    @DisplayName("Divide resulting in decimal")
    void testDivideDecimal() {
        assertEquals(2.5, calculator.divide(5, 2));
    }

    @Test
    @DisplayName("Divide by zero throws ArithmeticException")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
        assertTrue(exception.getMessage().contains("Division by zero"));
    }

    @Test
    @DisplayName("Divide zero by a number returns zero")
    void testZeroDividedByNumber() {
        assertEquals(0.0, calculator.divide(0, 5));
    }
}