// Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak
// 把最后一个two单词首字母大写
public class Main {
    public static void main(String[] args) {
        String s = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        System.out.println(replaceFrom(s,"two" ,"TWO", s.lastIndexOf("two")));
    }

    static String replaceFrom(String oldString,String replace,String replacement,int start){
        return oldString.substring(0,start)+oldString.substring(start).replace(replace, replacement);
    }
}