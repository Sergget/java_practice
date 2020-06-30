import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.io.File;

// 设计一个方法，用于移除Java文件中的注释
// public void removeComments(File javaFile)
// 注： 如果注释在后面，或者是/**/风格的注释，暂不用处理
public class Main {
    public static void main(String[] args) {
        File src = new File(".//src.java");
        removeComments(src);
    }

    static void removeComments(File javaFile) {
        //重命名源文件至缓存文件，并在成功处理之后需要删除
        //新建目的文件保使用源文件的文件名，重命名后源文件的内容会被转移到目标文件对象下，源文件对象的引用仍然可以使用
        File srcFile = new File(javaFile.getName()+".temp");
        javaFile.renameTo(srcFile);

        try (BufferedReader bf = new BufferedReader(new FileReader(srcFile, StandardCharsets.UTF_8));
                PrintWriter pw = new PrintWriter(new FileWriter(javaFile, StandardCharsets.UTF_8));) {
            while (true) {
                String line = bf.readLine();
                if (line == null) {
                    break;
                } else if (!line.startsWith("//")) {
                    pw.println(line);
                }
            }
            srcFile.deleteOnExit();
        } catch (Exception e) {
            e.printStackTrace();
            srcFile.renameTo(javaFile);
        }
    }
}