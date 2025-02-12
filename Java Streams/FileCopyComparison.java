import java.io.*;

public class FileCopyComparison {
    private static final int BUFFER_SIZE = 4096; 

    public static void main(String[] args) {
        String sourceFile = "source.txt";  
        String destinationFileBuffered = "copy_buffered.dat";
        String destinationFileUnbuffered = "copy_unbuffered.dat";

       
        long bufferedTime = copyFileUsingBufferedStreams(sourceFile, destinationFileBuffered);
        System.out.println("Buffered Streams Copy Time: " + bufferedTime + " nanoseconds");

       
        long unbufferedTime = copyFileUsingUnbufferedStreams(sourceFile, destinationFileUnbuffered);
        System.out.println("Unbuffered Streams Copy Time: " + unbufferedTime + " nanoseconds");

        
        System.out.println("Buffered copy is " + (unbufferedTime / (double) bufferedTime) + " times faster than unbuffered copy.");
    }


    private static long copyFileUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error in Buffered Copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    
    private static long copyFileUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            System.out.println("Error in Unbuffered Copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
