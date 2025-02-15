import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

       
        List<String> currencyValues = extractCurrencyValues(text);

        
        System.out.println(String.join(", ", currencyValues));
    }

    public static List<String> extractCurrencyValues(String text) {
        List<String> values = new ArrayList<>();
        
       
        String regex = "\\$?\\d+\\.\\d{2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            values.add(matcher.group());
        }

        return values;
    }
}
