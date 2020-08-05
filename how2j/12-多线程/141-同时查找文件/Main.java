import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

//遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容，不必等待这个线程结束，继续遍历下一个文件

public class Main {
    public static void main(String[] args) {
        File f = new File("..//..//08-IO");
        search(f, "Scanner");
    }

    public static void search(File folder, String search) {
        if (folder.isDirectory()) {
            File[] fs = folder.listFiles();
            for (File file : fs) {
                search(file, search);
            }
        } else {
            if (folder.getName().endsWith(".java")) {
                Thread t = new Thread() {
                    public void run() {
                        try (BufferedReader br = new BufferedReader(new FileReader(folder, StandardCharsets.UTF_8))) {
                            while (true) {
                                String line = br.readLine();
                                if (line == null) {
                                    break;
                                } else if (line.indexOf(search) != -1) {
                                    System.out.printf("找到目标子字符串: %s，文件为: %s\n", search, folder.getCanonicalPath());
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
            }
        }
    }
}