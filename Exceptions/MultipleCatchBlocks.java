import java.io.*;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        //int[] arr = {4, 6, 2, 9};
        int[] arr = null;
        int index = 4;
        try{
            System.out.println("Value at index " + index + ": " + arr[index]);           
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Invalid index! ");
        }catch(NullPointerException e){
            System.err.println("Array is not initialized! ");
        }
        
    }
    
}
