import java.util.regex.*;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String input = "This   is  an   example    with multiple    spaces.";
        
       
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(input);
        
        
        String output = matcher.replaceAll(" ");
        
        System.out.println(output);
    }
}
