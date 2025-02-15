import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String ip1 = "192.168.1.1";
        String ip2 = "256.100.50.25";
        String ip3 = "172.16.0.300";
        String ip4 = "10.0.0.1";

        System.out.println(ip1 + " is valid: " + isValidIPv4(ip1)); 
        System.out.println(ip2 + " is valid: " + isValidIPv4(ip2)); 
        System.out.println(ip3 + " is valid: " + isValidIPv4(ip3)); 
        System.out.println(ip4 + " is valid: " + isValidIPv4(ip4)); 
    }

    public static boolean isValidIPv4(String ip) {
        String regex = "^(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                     + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                     + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                     + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
