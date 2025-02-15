import java.util.regex.*;
import java.util.ArrayList;

public class CapitalizedWordExtractor {
    public static ArrayList<String> extractCapitalizedWords(String text) {
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> capitalizedWords = new ArrayList<>();
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        ArrayList<String> words = extractCapitalizedWords(text);

        System.out.println(words);
    }
}
