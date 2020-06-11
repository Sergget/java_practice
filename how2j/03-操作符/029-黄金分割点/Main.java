public class Main {
    // 寻找某两个数相除，其结果 离黄金分割点 0.618最近
    // 分母和分子不能同时为偶数
    // 分母和分子 取值范围在[1-20]
    public static void main(String[] args) {
        double min = 20;
        double delta = 0;
        int di = 1, dj = 1;
        for (double i = 20; i > 1; i--) {
            for (double j = 1; j <= i; j++) {
                delta = Math.abs(j / i - 0.618);
                if (delta < min) {
                    min = delta;
                    di = (int) i;
                    dj = (int) j;
                }
            }
        }
        System.out.println("分子：" + dj + "，分母：" + di+"，离0.618差值："+min);
    }
}