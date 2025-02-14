import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Enter dividend: ");
            int num1 = sc.nextInt();

            System.out.print("Enter divisor: ");
            int num2 = sc.nextInt();

            int divide = num1 / num2;
            System.out.println("The quotient is: " + divide);
           

        }catch(ArithmeticException e){
            System.err.println("Error: Division by zero is not allowed. " + e);
        }catch(InputMismatchException e){
            System.err.println("Error: Invalid input. Please enter numeric values. " + e);
        }finally{
            sc.close();
        }
    }
    
}
