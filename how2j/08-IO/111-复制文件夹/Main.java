import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
// 复制文件夹,实现如下方法，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
// public static void copyFolder(String srcFolder, String destFolder){
// }

public class Main {
    public static void main(String[] args) {
        copyFolder("E://src", "E://dest");
    }

    static void copyFolder(String srcFolder, String destFolder) {
        File src = new File(srcFolder);
        File dest = new File(destFolder);

        class CopyDir {
            public void copy(File src, File dest) {
                if (src.isDirectory()) {
                    dest.mkdirs();
                    File[] fs = src.listFiles();
                    System.out.printf("\n copying folder: %s ===> %s",src,dest);
                    for (File file : fs) {
                        copy(file, dest);
                    }
                } else {
                    dest.mkdirs();
                    File destFile = new File(dest, src.getName());
                    System.out.printf("\n copying file: %s ===> %s",src,destFile);
                    copyFile(src, destFile);   
                }
            }

            private void copyFile(File src, File dest) {
                try (FileInputStream fi = new FileInputStream(src); FileOutputStream fo = new FileOutputStream(dest);) {
                    int n;
                    while ((n = fi.read()) != -1) {
                        fo.write(n);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        CopyDir cp = new CopyDir();
        cp.copy(src,dest);
    }
}