import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//复制文件是常见的IO操作，设计如下方法，实现复制源文件srcFile到目标文件destFile
//public static void copyFile(String srcFile, String destFile){
//}

public class Main {
  public static void main(String[] args) {
      copyFile("srcFile.txt", "destFile.java");      
  }
  static void copyFile(String srcFile, String destFile){
      File src = new File(srcFile);
      File dest = new File(destFile);
      try (FileInputStream fi = new FileInputStream(src);FileOutputStream fo = new FileOutputStream(dest);){
          int n;
          while((n=fi.read())!=-1){
              fo.write(n);
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}