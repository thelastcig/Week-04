import java.util.*;
import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        
        Set<String> repeatingWords = findRepeatingWords(text);

     
        System.out.println(String.join(", ", repeatingWords));
    }

    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeatedWords = new HashSet<>();
        
      
        String regex = "\\b(\\w+)\\b(?:\\s+\\1\\b)";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1)); 
        }

        return repeatedWords;
    }
}
