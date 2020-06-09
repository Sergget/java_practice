public class Main {
    public static void main(String[] args) {
        int i = 1;
        boolean b = !(i++ == 3) ^ (i++ ==2) && (i++==3);
        //请先手工计算，在运行程序
        System.out.println(b);
        System.out.println(i); 
    }
}