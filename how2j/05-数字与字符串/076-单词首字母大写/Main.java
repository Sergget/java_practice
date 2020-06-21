// 给出一句英文句子： "let there be light"
// 得到一个新的字符串，每个单词的首字母都转换为大写
public class Main {
    public static void main(String[] args) {
        String s = "let there be light";

        String[] ss = s.split(" ");
        for (int i=0;i<ss.length;i++){
            ss[i] = Character.toUpperCase(ss[i].charAt(0))+ss[i].substring(1, ss[i].length());
        }

        System.out.println(String.join(" ", ss));
    }
}