import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please input class name:");
        String temp = s.nextLine();
        String className = temp.substring(0, 1).toUpperCase() + temp.substring(1).toLowerCase();
        System.out.println("Please input type of a property:");
        String type = s.nextLine();
        System.out.println("Please input name of the property:");
        String property = s.nextLine();
        String Uproperty = property.substring(0, 1).toUpperCase() + property.substring(1);
        s.close();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(".//template.txt")));
                PrintWriter pw = new PrintWriter(new FileWriter(new File(".//", className + ".java")));) {
            while (true) {
                String line =br.readLine();
                if(line==null){
                    break;
                }
                pw.println(line.replace("@class@", className).replace("@type@", type)
                        .replace("@property@", property).replace("@Uproperty@", Uproperty));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}