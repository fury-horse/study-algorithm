package class01;


/**
* @desc    冒泡排序
* 时间复杂度：O(N2)
* @version 1.0
* @author  Liang Jun
* @date    2020年05月23日 15:19:23
**/
public class Code02_BubbleSort {
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

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //my case
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }

        //teacher case
//        for (int i = arr.length-1; i > 0; i--) {
//            for (int j = 0; j < i; j ++) {
//                if (arr[j] > arr[j+1]) {
//                    swap(arr, j, j+1);
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr1 = generateRandomArray(maxSize, maxValue);

        System.out.println("Before sort:");
        printArray(arr1);

        bubbleSort(arr1);
        System.out.println("\nAfter sort:");
        printArray(arr1);
    }
}