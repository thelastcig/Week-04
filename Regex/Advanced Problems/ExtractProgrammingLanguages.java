import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

       
        String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "PHP"};

       
        List<String> extractedLanguages = extractLanguages(text, languages);

  
        System.out.println(String.join(", ", extractedLanguages));
    }

    public static List<String> extractLanguages(String text, String[] languages) {
        List<String> foundLanguages = new ArrayList<>();
        for (String lang : languages) {
            String regex = "\\b" + Pattern.quote(lang) + "\\b"; 
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                foundLanguages.add(lang);
            }
        }
        return foundLanguages;
    }
}
