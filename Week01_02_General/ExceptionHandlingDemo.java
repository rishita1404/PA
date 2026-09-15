import java.util.Scanner;
public class ExceptionHandlingDemo {
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
    public static double divide(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is undefined.");
        }
        return (double) numerator / denominator;
    }
    public static int getElementAtIndex(int[] arr, int index) throws ArrayIndexOutOfBoundsException {
        return arr[index];
    }
    public static void validateAge(int age) throws InvalidInputException {
        if (age < 0 || age > 150) {
            throw new InvalidInputException("Age " + age + " is outside acceptable human range [0, 150].");
        }
    }
    public static void main(String[] args) {
        System.out.println("=== Java Exception Handling Demonstration ===");
        System.out.println("\n--- Scenario 1: ArithmeticException ---");
        try {
            int a = 10, b = 0;
            System.out.printf("Attempting %d / %d...%n", a, b);
            double res = divide(a, b);
            System.out.println("Result: " + res);
        } catch (ArithmeticException ex) {
            System.err.println("Caught ArithmeticException: " + ex.getMessage());
        } finally {
            System.out.println("Finally block executed for Scenario 1.");
        }
        System.out.println("\n--- Scenario 2: ArrayIndexOutOfBoundsException ---");
        int[] numbers = { 10, 20, 30, 40 };
        try {
            int index = 5;
            System.out.printf("Accessing index %d in array of length %d...%n", index, numbers.length);
            int val = getElementAtIndex(numbers, index);
            System.out.println("Value: " + val);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " + ex.getMessage());
        } finally {
            System.out.println("Finally block executed for Scenario 2.");
        }
        System.out.println("\n--- Scenario 3: Multiple Catch Blocks ---");
        String[] rawData = { "42", "0", "abc" };
        for (int i = 0; i <= rawData.length; i++) {
            try {
                System.out.printf("Processing index %d: ", i);
                String item = rawData[i];
                int val = Integer.parseInt(item);
                int quotient = 100 / val;
                System.out.printf("100 / %d = %d%n", val, quotient);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("Array index out of range: " + ex.getMessage());
            } catch (ArithmeticException ex) {
                System.err.println("Math error: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                System.err.println("Number format error: " + ex.getMessage());
            } catch (Exception ex) {
                System.err.println("General exception: " + ex.getMessage());
            } finally {
                System.out.println("  (End of iteration " + i + ")");
            }
        }
        System.out.println("\n--- Scenario 4: Custom Exception ---");
        try {
            validateAge(-5);
        } catch (InvalidInputException e) {
            System.err.println("Caught Custom Exception: " + e.getMessage());
        } finally {
            System.out.println("Validation cleanup completed.");
        }
    }
}
