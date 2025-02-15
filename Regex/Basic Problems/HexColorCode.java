import java.util.regex.Pattern;
public class HexColorCode {
    public static boolean isValidHexCode(String code){
        String regex = "^[#][0-9a-fA-F]{6}$";
        return Pattern.matches(regex, code);
    }
    public static void main(String[] args) {
        System.out.println(isValidHexCode("#FFA500"));
        System.out.println(isValidHexCode("#FFA10"));
        System.out.println(isValidHexCode("#123"));
    }
    
}
