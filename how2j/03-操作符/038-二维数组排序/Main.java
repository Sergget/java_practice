import java.util.Arrays;

public class Main {
    // 首先定义一个5X8的二维数组，然后使用随机数填充满。
    // 借助Arrays的方法对二维数组进行排序。
    // 参考思路：
    // 先把二维数组使用System.arraycopy进行数组复制到一个一维数组
    // 然后使用sort进行排序
    // 最后再复制回到二维数组。
    public static void main(String[] args) {
        int[][] arr2d = generateRandomArray2d(5, 8);
        printArray2d(arr2d);
        printArray2d(getSortedArray2d(arr2d));
    }

    // 填充二维数组
    static int[][] generateRandomArray2d(int rows, int columns) {
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }
        return arr;
    }

    // 二维数组排序
    static int[][] getSortedArray2d(int[][] arr2d) {
        int rows = arr2d.length;
        int columns = arr2d[0].length;
        int[] tempArray = new int[rows * columns];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(arr2d[i], 0, tempArray, i * columns, columns);
        }
        tempArray = getSorted(tempArray);
        int[][] result = new int[rows][columns];
        for (int i = 0; i < result.length; i++) {
            System.arraycopy(tempArray, i * columns, result[i], 0, columns);
        }
        return result;
    }

    // 一维数组排序
    static int[] getSorted(int[] arr) {
        // 选择排序法
        int[] result = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i] > result[j]) {
                    int temp = result[j];
                    result[j] = result[i];
                    result[i] = temp;
                }
            }
        }
        return result;
    }

    // 打印二维数组
    static void printArray2d(int[][] arr2d) {
        System.out.println(arr2d + ":");
        for (int[] is : arr2d) {
            System.out.println(Arrays.toString(is));
        }
    }
}