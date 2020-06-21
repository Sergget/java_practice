import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

// 创建一个长度是100的字符串数组
// 使用长度是2的随机字符填充该字符串数组
// 统计这个字符串数组里重复的字符串有多少种
public class Main {
    public static void main(String[] args) {
        String[] ss = new String[100];
        for (int i = 0; i < ss.length; i++) {
            ss[i]=randomString(2);
        }
        StringJoiner sja = new StringJoiner(",","[","]");
        for (String string : ss) {
            sja.add(string);
        }
        System.out.println("Original: "+sja.toString());

        List<String> ls = new ArrayList<>();

        for (int i = 0; i < ss.length; i++) {
            if(ls.contains(ss[i])){
                continue;
            }else{
                for (int j = 0; j < ss.length; j++) {
                    if(ss[i].equals(ss[j]) && i!=j){
                        ls.add(ss[i]);
                    }
                }
            }
        }

        StringJoiner sj = new StringJoiner(",","[","]");
        for (String string : ls) {
            sj.add(string);
        }
        System.out.println(ls.size()+" in total, result: "+sj.toString());
    }

    static String randomString(int length){
        String temp = "";
        for(short i ='A';i<='Z';i++){
            temp+=(char) i;
        }
        for(short j='a';j<='z';j++){
            temp+=(char) j;
        }
        for(short k=0;k<=9;k++){
            temp+=k;
        }
        String result = "";
        for(int n=0;n<length;n++){
            result+=temp.charAt((int) (Math.random()*temp.length()));
        }
        return result;
    }
}