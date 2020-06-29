import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//把100-拆分文件中拆分出来的文件，合并成一个原文件。
//以是否能正常运行，验证合并是否正确

public class Main {
    public static void main(String[] args) {
        File dest = new File(".//target//test.txt");
        File src = new File("..//100-拆分文件//target//");
        dest.getParentFile().mkdirs();

        try (FileOutputStream fo = new FileOutputStream(dest)) {
            File[] fs = src.listFiles();
            for (File file : fs) {
                try (FileInputStream fi = new FileInputStream(file)) {
                    fo.write(fi.readAllBytes());
                    // fo.flush();
                    System.out.printf("\nConcating %s, size of which is: %d", file.getName(), file.length());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}