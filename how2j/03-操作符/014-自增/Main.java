public class Main {
    public static void main(String[] args) {
        int i = 1;
        int j = ++i + i++ + ++i + ++i + i++;
        //请先手工计算，在运行程序
        System.out.println(j);
    }
}