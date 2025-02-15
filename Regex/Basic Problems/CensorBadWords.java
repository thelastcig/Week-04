import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"}; 
        
        
        String censoredOutput = censorText(input, badWords);
        
        System.out.println(censoredOutput);
    }

    public static String censorText(String text, String[] badWords) {
        for (String word : badWords) {
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            text = text.replaceAll(regex, "****");
        }
        return text;
    }
}
