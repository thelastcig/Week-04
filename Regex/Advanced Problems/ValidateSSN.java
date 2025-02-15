import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String ssn1 = "123-45-6789";  
        String ssn2 = "123456789";   
        String ssn3 = "987-65-4321";  
        String ssn4 = "123-4A-6789"; 

        System.out.println(validateSSN(ssn1)); 
        System.out.println(validateSSN(ssn2)); 
        System.out.println(validateSSN(ssn3));
        System.out.println(validateSSN(ssn4)); 
    }

    public static String validateSSN(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        if (matcher.matches()) {
            return ssn + " is valid";
        } else {
            return ssn + " is invalid";
        }
    }
}
