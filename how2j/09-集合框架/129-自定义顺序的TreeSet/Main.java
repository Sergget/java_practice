import java.util.Comparator;
import java.util.TreeSet;

// 默认情况下，TreeSet中的数据是从小到大排序的，不过TreeSet的构造方法支持传入一个Comparator
// public TreeSet(Comparator comparator) 
// 通过这个构造方法创建一个TreeSet，使得其中的的数字是倒排序的
public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        for (int i = 0; i < 10; i++) {
            ts.add((int) (Math.random()*20));
        }
        System.out.println(ts);
    }
}