import java.util.regex.*;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return Pattern.matches(regex, username);
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user_123"));
        System.out.println(isValidUsername("123user"));  
        System.out.println(isValidUsername("us"));        
        System.out.println(isValidUsername("user__name_"));  
        System.out.println(isValidUsername("user-name"));    
    }
}
