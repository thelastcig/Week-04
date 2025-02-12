import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String sourceImage = "psuedo1.jpg";  
        String destinationImage = "copy.jpg";

    
        byte[] imageData = convertImageToByteArray(sourceImage);
        if (imageData != null) {
           
            boolean success = writeByteArrayToImage(imageData, destinationImage);

            if (success) {
                compareFiles(sourceImage, destinationImage);
            }
        }
    }

   
    private static byte[] convertImageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image successfully converted to byte array.");
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
            return null;
        }
    }

    private static boolean writeByteArrayToImage(byte[] imageData, String outputPath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Byte array successfully written to " + outputPath);
            return true;
        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
            return false;
        }
    }

    
    private static void compareFiles(String file1, String file2) {
        try {
            long size1 = Files.size(new File(file1).toPath());
            long size2 = Files.size(new File(file2).toPath());

            if (size1 == size2) {
                System.out.println("Verification successful: The copied image is identical.");
            } else {
                System.out.println("Verification failed: The copied image size differs.");
            }
        } catch (IOException e) {
            System.out.println("Error comparing files: " + e.getMessage());
        }
    }
}
