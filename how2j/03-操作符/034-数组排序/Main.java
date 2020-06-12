import java.util.Arrays;

public class Main {
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
        //选择排序法
        int[] result = Arrays.copyOf(arr, arr.length);
        for(int i=0;i<result.length;i++){
            for(int j = i+1;j<result.length;j++){
                if(result[i]>result[j]){
                    int temp=result[j];
                    result[j]=result[i];
                    result[i]=temp;
                }
            }
        }
        return result;
    }
}