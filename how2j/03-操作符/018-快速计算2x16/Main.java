//不用乘法符号(*) 计算 2x16
public class Main {
    public static void main(String[] args) {
        System.out.println("2 * 16 = "+mutiply(2, 16));
        System.out.println("2 * 17 = "+mutiply(2, 17));
        System.out.println("11 * 17 = "+mutiply(11, 17));
        System.out.println("12 * 17 = "+mutiply(12, 17));
    }

    static int mutiply(int n1, int n2) {
        String bn2=Integer.toBinaryString(n2);
        int result = 0;
        char[] charArr = bn2.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i]=='1'){
                result=result+n1<<(charArr.length-i-1);
            }
        }
        return result;
    }
}
