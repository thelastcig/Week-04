import java.util.regex.*;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String card1 = "4111111111111111"; 
        String card2 = "5111111111111111"; 
        String card3 = "6111111111111111"; 
        String card4 = "4222222222222";    
        System.out.println(card1 + " is valid: " + isValidCreditCard(card1)); // true
        System.out.println(card2 + " is valid: " + isValidCreditCard(card2)); // true
        System.out.println(card3 + " is valid: " + isValidCreditCard(card3)); // false
        System.out.println(card4 + " is valid: " + isValidCreditCard(card4)); // false
    }

    public static boolean isValidCreditCard(String cardNumber) {
        String regex = "^(4[0-9]{15}|5[0-9]{15})$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }
}
