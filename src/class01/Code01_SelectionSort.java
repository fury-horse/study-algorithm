package class01;


/**
* @desc    选择排序
* 时间复杂度：O(N2)
* @version 1.0
* @author  Liang Jun
* @date    2020年05月23日 14:27:15
**/
public class Code01_SelectionSort {
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
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr1 = generateRandomArray(maxSize, maxValue);

        System.out.println("Before sort:");
        printArray(arr1);

        selectionSort(arr1);
        System.out.println("\nAfter sort:");
        printArray(arr1);
    }
}