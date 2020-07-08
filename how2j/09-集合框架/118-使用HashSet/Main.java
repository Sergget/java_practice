import java.util.HashSet;

//创建一个长度是100的字符串数组
//使用长度是2的随机字符填充该字符串数组
//统计这个字符串数组里重复的字符串有多少种
//使用HashSet来解决这个问题

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[100];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = randomString(2);
        }

        HashSet<String> hs = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (String string : strings) {
            //hashset的add方法添加不重复元素返回true，否则false
            if(!hs.add(string)){
                repeated.add(string);
            }
        }
        System.out.println(repeated);
    }

    public static String randomString(int length) {
        String temp = "";
        for (short i = 'A'; i <= 'Z'; i++) {
            temp += (char) i;
        }
        for (short j = 'a'; j <= 'z'; j++) {
            temp += (char) j;
        }
        for (short k = 0; k <= 9; k++) {
            temp += k;
        }
        String result = "";
        for (int n = 0; n < length; n++) {
            result += temp.charAt((int) (Math.random() * temp.length()));
        }
        return result;
    }
}