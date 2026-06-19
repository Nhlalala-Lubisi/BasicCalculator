import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Basic Calculator
 * Nhlaks
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        boolean running = true;

        while (running) {
            System.out.println("\nSelect an operation:");
            System.out.println("  1. Addition       (+)");
            System.out.println("  2. Subtraction    (-)");
            System.out.println("  3. Multiplication (×)");
            System.out.println("  4. Division       (÷)");
            System.out.println("  5. Exit");
            System.out.print("\nEnter choice (1-5): ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear the buffer
                continue;
            }

            if (choice == 5) {
                System.out.println("\nGoodbye!");
                running = false;
                continue;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please select 1–5.");
                continue;
            }

            double a, b;
            try {
                System.out.print("Enter first number:  ");
                a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                b = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Please enter a valid numeric value.");
                scanner.nextLine();
                continue;
            }

            try {
                double result = switch (choice) {
                    case 1 -> calculator.add(a, b);
                    case 2 -> calculator.subtract(a, b);
                    case 3 -> calculator.multiply(a, b);
                    case 4 -> calculator.divide(a, b);
                    default -> throw new IllegalStateException("Unexpected choice: " + choice);
                };

                String operator = switch (choice) {
                    case 1 -> "+";
                    case 2 -> "-";
                    case 3 -> "×";
                    case 4 -> "÷";
                    default -> "?";
                };

                // Format: remove unnecessary trailing zeros
                String formattedResult = (result == Math.floor(result) && !Double.isInfinite(result))
                        ? String.valueOf((long) result)
                        : String.valueOf(result);

                String fa = (a == Math.floor(a) && !Double.isInfinite(a)) ? String.valueOf((long) a) : String.valueOf(a);
                String fb = (b == Math.floor(b) && !Double.isInfinite(b)) ? String.valueOf((long) b) : String.valueOf(b);
                System.out.printf("%n  %s %s %s = %s%n", fa, operator, fb, formattedResult);

            } catch (ArithmeticException e) {
                System.out.println("\n  " + e.getMessage());
            }
        }

        scanner.close();
    }
}
