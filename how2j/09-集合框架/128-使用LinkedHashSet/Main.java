import java.util.LinkedHashSet;
import java.util.List;

//利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
public class Main{
    public static void main(String[] args) {
        String pi = (Math.PI+"").replace(".", "");
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        for (char s : pi.toCharArray()) {
            lhs.add(s);
        }
        System.out.println(lhs);
    }
}