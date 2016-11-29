import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class App {
    private static Scanner scanner;

    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config/config.properties"));
            scanner = new Scanner(System.in);
            String line = null;
            System.out.print("please input:");
            while (!"exit".equals(line = scanner.nextLine())) {
                System.out.println("input context = " + line);
                System.out.print("please input: ");
                File writename = new File(prop.getProperty("file.name")); 
                writename.createNewFile();  
                BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
                out.write(line); 
                out.flush();  
                out.close();  
            }
            System.out.println("The program will exit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}