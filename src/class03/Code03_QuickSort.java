package class03;


/**
* @desc    快速排序（快排）
* 时间复杂度：O(N*logN)
* @version 1.0
* @author  Liang Jun
* @date    2020年05月23日 17:51:26
**/
public class Code03_QuickSort {
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
        //递归终止条件
        if (L >= R) {
            return;
        }

        //计算出相等的中间区域
        int[] equalArea = netherlandsFlag(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }

    private static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }

        int num = arr[R];
        int lessArea = L-1; //小于区域
        int moreArea = R;   //大于区域

        int index = L;
        while (index < moreArea) {
            //当前元素等于指定值，下标增加，等于区域扩大
            if (arr[index] == arr[R]) {
                index ++;
            }
            //当前元素大于指定值，大于区域元素和当前元素替换，当前下标不增加，大区域下标递减
            else if (arr[index] > arr[R]) {
                swap(arr, index, --moreArea);
            }
            //当前元素小于指定值，小区域元素和当前元素替换，当前下标递增，小区域下标递增
            else {
                swap(arr, index++, ++lessArea);
            }
        }

        swap(arr, moreArea, R);

        return new int[]{lessArea+1, moreArea};
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