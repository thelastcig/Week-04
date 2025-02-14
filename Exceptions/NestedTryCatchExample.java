import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50}; 

        try {
            
            System.out.print("Enter index to access: ");
            int index = sc.nextInt();

            try {
                
                int value = arr[index]; 
              
                System.out.print("Enter divisor: ");
                int divisor = sc.nextInt();

                try {
                    
                    int result = value / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.err.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Invalid array index!");
            }

        } catch (Exception e) {
            System.err.println("Invalid input! Please enter a valid integer.");
        } finally {
            sc.close();
        }
    }
}
