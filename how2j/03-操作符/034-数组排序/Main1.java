import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = (int) (Math.random() * 100);
        a[1] = (int) (Math.random() * 100);
        a[2] = (int) (Math.random() * 100);
        a[3] = (int) (Math.random() * 100);
        a[4] = (int) (Math.random() * 100);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(getSorted(a)));
        System.out.println(Arrays.toString(a));
    }

    static int[] getSorted(int[] arr) {
        //冒泡排序法
        int[] result = Arrays.copyOf(arr, arr.length);
        for(int i=0;i<result.length-1;i++){
            for(int j = 0;j<result.length-i-1;j++){
                if(result[j]>result[j+1]){
                    int temp=result[j];
                    result[j]=result[j+1];
                    result[j+1]=temp;
                }
            }
        }
        return result;
    }
}