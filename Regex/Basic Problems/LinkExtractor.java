import java.util.regex.*;
import java.util.*;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = extractLinks(text);
        
        System.out.println(String.join(", ", links));
    }
    
    public static List<String> extractLinks(String text) {
        List<String> linkList = new ArrayList<>();
        String linkPattern = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\S*\\b";
        Pattern pattern = Pattern.compile(linkPattern);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            linkList.add(matcher.group());
        }
        
        return linkList;
    }
}
