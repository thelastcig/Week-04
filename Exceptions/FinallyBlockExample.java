import java.util.Scanner;

public class FinallyBlockExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter dividend: ");
            int dividend = sc.nextInt();

            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();

            int result = dividend / divisor;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: Cannot divide by zero.");
        } catch (Exception e) {
            System.err.println("Invalid input! Please enter valid integers.");
        } finally {
            System.out.println("Operation completed."); 
            sc.close(); 
        }
    }
}
