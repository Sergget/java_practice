// 英文绕口令
// peter piper picked a peck of pickled peppers
// 统计这段绕口令有多少个以p开头的单词
public class Main {
    public static void main(String[] args) {
        String s = "peter piper picked a peck of pickled peppers";
        String[] ss = s.split(" ");

        int count = 0;
        for (String string : ss) {
            if(string.charAt(0)=='p'){
                count++;
            }
        }
        System.out.println(count);
    }
}