//把 lengendary 最后一个字母变大写
public class Main {
    public static void main(String[] args) {
        String s = "lengendary";
        System.out.println(s.substring(0, s.length()-1)+Character.toUpperCase(s.charAt(s.length()-1)));
    }
}