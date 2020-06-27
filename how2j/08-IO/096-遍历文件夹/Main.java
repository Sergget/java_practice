import java.io.File;
import java.util.ArrayList;
import java.util.List;

// 一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。
// 遍历这个目录下所有的文件(不用遍历子目录)
// 找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
// 注: 最小的文件不能是0长度
public class Main {
    public static void main(String[] args) {
        File dir = new File("C:\\windows");
        List<Long> lengths = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        for (File file:File.listRoots()) {
            System.out.println(file);
        }

        for (String file : dir.list()) {
            File fo = new File(dir, file);
            if (fo.isFile()) {
                lengths.add(Long.valueOf(fo.length()));
                paths.add(fo.getAbsolutePath());
            }
        }

        long max = 0;
        for (long length : lengths) {
            if (length > max) {
                max = length;
            }
        }

        System.out.printf("Longest file is: %s, length of which is: %d bytes\n", paths.get(lengths.indexOf(max)),
                max);

        long min = max;
        for (long length : lengths) {
            if (length < min && length > 0) {
                min = length;
            }
        }

        System.out.printf("Shortest file is: %s, length of which is: %d bytes\n", paths.get(lengths.indexOf(min)),
                min);
    }
}