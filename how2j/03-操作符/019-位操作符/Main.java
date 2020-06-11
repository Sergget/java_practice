public class Main {
    public static void main(String[] args) {
        int i = 3; // 二进制是11
        int j = 2; // 二进制是10
        int c = ((i | j) ^ (i & j)) << 2 >>> 1;
        System.out.println(c);
        System.out.println(2<<2);
    }
}