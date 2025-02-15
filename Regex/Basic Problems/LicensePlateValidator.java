import java.util.regex.*;

public class LicensePlateValidator {
    public static boolean isValidPlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        return Pattern.matches(regex, plate);
    }

    public static void main(String[] args) {
        System.out.println(isValidPlate("AB1234"));  
        System.out.println(isValidPlate("A12345"));
        System.out.println(isValidPlate("ABC123")); 
        System.out.println(isValidPlate("AB12A4")); 
    }
}
