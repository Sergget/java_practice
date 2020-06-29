import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

// 找到一个大于1kb字节的文件，按照1kb为单位，拆分成多个子文件，并且以编号作为文件名结束。
// 比如文件 test.txt，大小是2.57k。
// 拆分之后，成为
// test.txt-00
// test.txt-01

public class Main {
    public static void main(String[] args) {
        File f = new File(".//test.txt");
        int blockSize = 1000;
        double blocks = Math.ceil(f.length()/blockSize)+1;

        try (FileInputStream fi = new FileInputStream(f);) {
            byte[] fiBytes = fi.readAllBytes();
            System.out.println(fiBytes.length+","+blockSize+","+blocks);
            for (int i = 0; i < blocks; i++) {
                File outPut = new File(".//target//",String.format("%s-%d", f.getName(),i));
                outPut.getParentFile().mkdirs();
                byte[] buffer = Arrays.copyOfRange(fiBytes, i*blockSize, f.length()<(i+1)*blockSize?(int) f.length():(i+1)*blockSize);
                try (FileOutputStream fo = new FileOutputStream(outPut)) {
                    fo.write(buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}