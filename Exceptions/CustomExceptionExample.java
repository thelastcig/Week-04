import java.io.*;
import java.util.Scanner;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
public class CustomExceptionExample {
    public static void validateAge(int age) throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException("Age must be 18 or above.");
        }
        System.out.println("Access Garnted");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter age to check: ");
            int age = sc.nextInt();
            validateAge(age);
            
        }catch(InvalidAgeException e){
            System.err.println("Error: " + e.getMessage());    
        }finally{
            sc.close();
        }
        
    }
}
