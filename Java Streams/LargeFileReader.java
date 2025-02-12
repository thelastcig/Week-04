import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "large_log.txt"; 

        readLargeFile(filePath);
    }

    private static void readLargeFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { 
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
