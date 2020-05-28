package class01;


/**
* @desc    插入排序
* 时间复杂度 O(N2)
* @version 1.0
* @author  Liang Jun
* @date    2020年05月23日 15:54:01
**/
public class Code03_InsertionSort {
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

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //teacher case
//        for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
//            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
//                swap(arr, j, j + 1);
//            }
//        }

//        //my case 1: j循环有问题
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j] < arr[j-1]) {
//                    swap(arr, j, j-1);
//                }
//            }
//        }

        //my case 1: j正确处理方式
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                swap(arr, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr1 = generateRandomArray(maxSize, maxValue);

        System.out.println("Before sort:");
        printArray(arr1);

        insertionSort(arr1);
        System.out.println("\nAfter sort:");
        printArray(arr1);
    }
}