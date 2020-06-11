public class Main {
    public static void main(String[] args) {
        // 水仙花数定义：
        // 1. 一定是3位数
        // 2. 每一位的立方，加起来恰好是这个数本身，比如153=1*1*1+5*5*5+3*3*3
        // 寻找所有的水仙花数
        for(int i=1;i<=9;i++){
            for(int j=0;j<=9;j++){
                for(int k=0;k<=9;k++){
                    if(Math.pow(i, 3)+Math.pow(j, 3)+Math.pow(k, 3)==100*i+10*j+k){
                        System.out.println(100*i+10*j+k);
                    }
                }
            }
        }
    }
}