import java.util.Arrays;

import javax.naming.ldap.ManageReferralControl;

public class Main {
    // 准备两个数组，他俩的长度是5-10之间的随机数，并使用随机数初始化这两个数组
    // 然后准备第三个数组，第三个数组的长度是前两个的和
    // 通过System.arraycopy 把前两个数组合并到第三个数组中
    public static void main(String[] args) {
        int[] arr1 = generateArray((int) (Math.random()*5)+5);
        int[] arr2 = generateArray((int) (Math.random()*5)+5);
        int[] arr3 = new int[arr1.length+arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        System.out.println("arr1: "+Arrays.toString(arr1));
        System.out.println("arr2: "+Arrays.toString(arr2));
        System.out.println("arr3: "+Arrays.toString(arr3));
    }
    static int[] generateArray(int length){
        int[] arr = new int[length];
        for(int i = 0;i<length;i++){
            arr[i]=(int) (Math.random()*100);
        }
        return arr;
    }
}