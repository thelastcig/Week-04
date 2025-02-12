import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes()); 
            pos.close(); 
        } catch (IOException e) {
            System.out.println("WriterThread Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            System.out.print("Reader received: ");
            while ((data = pis.read()) != -1) { 
                System.out.print((char) data);
            }
            System.out.println(); 
            pis.close();
        } catch (IOException e) {
            System.out.println("ReaderThread Error: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
         
            Thread writer = new WriterThread(pos);
            Thread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

        } catch (IOException e) {
            System.out.println("Error connecting streams: " + e.getMessage());
        }
    }
}
