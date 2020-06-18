import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List<Integer> primes = new ArrayList<>();
        int count =0;

        for(int i = 2;i<10000000;i++){
            if(isPrimes(i)){
                // primes.add(Integer.valueOf(i));
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isPrimes(int n){
        if(n==2){
            return true;
        }else if(n>2){
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}