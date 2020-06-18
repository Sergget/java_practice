public class Prime{
    public static void main(String[] args) {
        int max = (int)1e7;
 
        //优秀算法
        long startTime =  System.currentTimeMillis();   //计时
        boolean[] notprimes = new boolean[max];         //标志器
        notprimes[0] = true;                            //默认0和1不是质数
        notprimes[1] = true;
        for (int i = 2 ; i<=Math.sqrt(notprimes.length); i++){
            if(!notprimes[i] && isPrime(i)){
                //如果某个数n是质数，那么2n,3n,4n.....n*n必然不是质数
                for (int j = i*2; j < max; j+=i) {
                    notprimes[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < max ; i++){
            if(!notprimes[i])   count++;            //计数
        }
        long endTime =  System.currentTimeMillis(); //结束计时
        long usedTime = endTime-startTime;
        System.out.println("改良方法：有"+count+"个质数，用了"+usedTime+"毫秒");
    }
 
    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(0==i%j)
                return false;
        }
        return true;
    }
}