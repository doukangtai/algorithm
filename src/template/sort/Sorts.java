package template.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author 窦康泰
 * @Date 2020-07-16 10:48
 */
public class Sorts {

    /**
     * 交换函数
     *
     * @param arr
     * @param a
     * @param b
     */
    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    static void bubbleSort(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            boolean flag = true;
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[temp] > arr[j]) {
                    temp = j;
                }
            }
            swap(arr, temp, i);
        }
    }

    /**
     * 插入排序1
     *
     * @param arr
     */
    static void insertSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 插入排序2
     *
     * @param arr
     */
    static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 二分插入排序
     *
     * @param arr
     */
    static void binaryInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int L = 0;
            int R = i - 1;
            while (L <= R) {
                int M = L + (R - L) / 2;
                if (key > arr[M]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
            for (int j = i - 1; j >= L; j--) {
                arr[j + 1] = arr[j];
            }
            arr[L] = key;
        }
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    static void shellSort(int[] arr) {
        for (int i = arr.length; i > 0; i /= 2) {
            for (int end = i; end < arr.length; end++) {
                int key = arr[end];
                int j;
                for (j = end - i; j >= 0 && key < arr[j]; j -= i) {
                    arr[j + i] = arr[j];
                }
                arr[j + i] = key;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int key = arr[left];
        while (l < r) {
            while (l < r && key <= arr[r]) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && key >= arr[l]) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = key;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int M = left + (right - left) / 2;
        mergeSort(arr, left, M);
        mergeSort(arr, M + 1, right);
        merge(arr, left, M, right);
    }

    static void merge(int[] arr, int L, int M, int R) {
        int p1 = L;
        int p2 = M + 1;
        int[] temp = new int[R - L + 1];
        int flag = 0;
        while (p1 <= M && p2 <= R) {
            temp[flag++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            temp[flag++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[flag++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[L++] = temp[i];
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int heapLastIndex = arr.length - 1;
        for (int i = (heapLastIndex - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        swap(arr, 0, heapLastIndex);
        while (heapLastIndex > 0) {
            heapify(arr, 0, heapLastIndex);
            swap(arr, 0, --heapLastIndex);
        }
    }

    static void heapify(int[] arr, int i, int heapSize) {
        int max = i;
        int L = i * 2 + 1;
        int R = i * 2 + 2;
        if (L < heapSize && arr[L] > arr[max]) {
            max = L;
        }
        if (R < heapSize && arr[R] > arr[max]) {
            max = R;
        }
        if (max != i) {
            swap(arr, max, i);
            heapify(arr, max, heapSize);
        }
    }

    /**
     * 计数排序
     *
     * @param arr
     */
    static void countSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int flag = -min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] + flag]++;
        }
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (bucket[i] != 0) {
                arr[j++] = i - flag;
                bucket[i]--;
            } else {
                i++;
            }
        }
    }

    /**
     * 桶排序
     *
     * @param arr
     * @param bucketSize
     */
    static void bucketSort(int[] arr, int bucketSize) {
        int min = arr[0];
        int max = arr[0];
        for (int item : arr) {
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<>());
        }
        for (int value : arr) {
            bucketArr.get((value - min) / bucketSize).add(value);
        }
        for (ArrayList<Integer> bucket : bucketArr) {
            Collections.sort(bucket);
        }
        int arrSize = 0;
        for (ArrayList<Integer> bucket : bucketArr) {
            for (Integer num : bucket) {
                arr[arrSize++] = num;
            }
        }
    }

    /**
     * main函数
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {6, 3, 4, 7, 3, 5};
//        bubbleSort(array);
//        selectSort(array);
//        insertSort1(array);
//        insertSort2(array);
//        binaryInsertSort(array);
//        shellSort(array);
//        quickSort(array, 0, array.length - 1);
//        mergeSort(array, 0, array.length - 1);
//        heapSort(array);
//        countSort(array);
        bucketSort(array, 4);
        System.out.println(Arrays.toString(array));
    }

}
