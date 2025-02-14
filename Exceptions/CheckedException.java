import java.io.*;

class CheckedException {
    public static void main(String[] args){
        try(FileReader fr = new FileReader("data.txt")){
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found " + e);
        }catch(IOException e){
            System.err.println("There was an error in reading the file: " + e);
        }
    }
    
}