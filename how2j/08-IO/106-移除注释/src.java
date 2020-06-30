import java.io.*;
import java.nio.charset.StandardCharsets;



public class Main {
    public static void main(String[] args) {
        File fi = new File(".//src.txt");
        File fo = new File(".//dest.txt");
        decodeFile(fi, fo);
    }

    static void decodeFile(File encodingfile, File encodedFile) {
        try (Reader reader = new FileReader(encodingfile, StandardCharsets.UTF_8);) {
            try (Writer writer = new FileWriter(encodedFile, StandardCharsets.UTF_8)) {
                int n;
                while ((n = reader.read()) != -1) {
                    switch ((char) n) {
                        case 'a':
                            n = 'z';
                            break;
                        case 'A':
                            n = 'Z';
                            break;
                        case '0':
                            n = '9';
                            break;
                        default:
                            if (Character.isUpperCase((char) n) || Character.isDigit((char) n)
                                    || Character.isLowerCase((char) n)) {
                                n--;
                            }
                            break;
                    }
                    writer.write(n);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
