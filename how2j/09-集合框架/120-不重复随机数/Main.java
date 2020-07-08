import java.util.HashSet;

//生成50个 0-9999之间的随机数，要求不能有重复的
public class Main {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        while (true) {
            if(hs.size()>=50){
                break;
            }
            hs.add((int) (Math.random()*9999));
        }
        System.out.println(hs);
        System.out.println(hs.size()+" random numbers in total");
    }
}