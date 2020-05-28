package class03;


import com.sun.org.apache.xpath.internal.operations.String;

import java.util.concurrent.CountDownLatch;

/**
* @desc    快速排序（快排）
* 时间复杂度：O(N*logN)
* @version 1.0
* @author  Liang Jun
* @date    2020年05月23日 17:51:26
**/
public class Code03_QS {
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length-1);
    }

    private static void process(int[] arr, int L, int R) {
        //循环终止条件
        if (L >= R) {
            return;
        }

        int[] equalArea = netherlandsFlag(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }

    private static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L == R) {
            return new int[]{L, R};
        }
        if (L > R) {
            return new int[]{-1, -1};
        }

        int eq = R;
        int less = L - 1;
        int more = R + 1;

        while (true) {
        }


    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr1 = generateRandomArray(maxSize, maxValue);

        System.out.println("Before sort:");
        printArray(arr1);

        quickSort(arr1);
        System.out.println("\nAfter sort:");
        printArray(arr1);
    }
}