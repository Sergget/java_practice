import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = (int) (Math.random() * 100);
        a[1] = (int) (Math.random() * 100);
        a[2] = (int) (Math.random() * 100);
        a[3] = (int) (Math.random() * 100);
        a[4] = (int) (Math.random() * 100);
        System.out.println(Arrays.toString(a)+" reversed is: "+Arrays.toString(getReverse(a)));;
    }

    static int[] getReverse(int[] arr){
        int[] temp = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            temp[i] = arr[arr.length-i-1];
        }
        return temp;
    }
}