import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

//遍历你的目录下所有的java文件（包括子文件夹），找出文件内容包括 Magic的那些文件，并打印出来。

public class Main {
    public static void main(String[] args) {
        File f = new File("..//..");
        search(f, "Scanner");
    }

    public static void search(File folder, String search) {
        if (folder.isDirectory()) {
            File[] fs = folder.listFiles();
            for (File file : fs) {
                search(file, search);
            }
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(folder, StandardCharsets.UTF_8))) {
                while (true) {
                    String line = br.readLine();
                    if(line==null){
                        break;
                    }else if (line.indexOf(search) != -1) {
                        System.out.printf("找到目标子字符串: %s，文件为: %s\n", search, folder.getCanonicalPath());
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}