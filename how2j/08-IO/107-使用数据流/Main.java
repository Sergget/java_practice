import java.io.*;

//使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字
 public class Main{
     public static void main(String[] args) {
         File fo = new File(".//dest.txt");
         try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fo))) {
             dos.writeInt(102);
             dos.writeInt(105);
         } catch (Exception e) {
             e.printStackTrace();
         }

         try (DataInputStream dis = new DataInputStream(new FileInputStream(fo))) {
                System.out.println(dis.readInt());
                System.out.println(dis.readInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
 }