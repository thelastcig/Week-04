import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "textfile.txt"; 

        countWords(filePath);
    }

    private static void countWords(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+"); 
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            
            List<Map.Entry<String, Integer>> sortedWords = wordCountMap.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .collect(Collectors.toList());

            
            int totalWords = wordCountMap.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Total Words: " + totalWords);

            
            System.out.println("Top 5 Most Frequent Words:");
            sortedWords.stream().limit(5).forEach(entry -> 
                System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
