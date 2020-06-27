import java.io.File;
import java.util.ArrayList;
import java.util.List;

// 一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。
// 遍历这个目录下所有的文件(包括子目录)
// 找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
// 注: 最小的文件不能是0长度
public class Main {
    public static void main(String[] args) {
        List<File> fl = new fileList("e:\\github_lib").FileListRec();
        List<Long> lengths = new ArrayList<>();

        for (File file : fl) {
            // System.out.println(file.getAbsolutePath());
            lengths.add(file.length());
        }

        long max = 0;
        for (long length : lengths) {
            if (length > max) {
                max = length;
            }
        }

        System.out.printf("Longest file is: %s, length of which is: %d bytes\n",
                fl.get(lengths.indexOf(max)).getAbsolutePath(), max);

        long min = max;
        for (long length : lengths) {
            if (length < min && length > 0) {
                min = length;
            }
        }

        System.out.printf("Shortest file is: %s, length of which is: %d bytes\n",
                fl.get(lengths.indexOf(min)).getAbsolutePath(), min);
    }
}

class fileList {
    private File rootDir;
    private List<File> fList = new ArrayList<>();

    public fileList() {
        this(".");
    }

    public fileList(String dirPath) {
        rootDir = new File(dirPath);
    }

    public List<File> FileListRec() {
        FileListRec(rootDir);
        return fList;
    }

    private void FileListRec(File root) {
        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                FileListRec(file);
            } else {
                fList.add(file);
            }
        }
    }
}