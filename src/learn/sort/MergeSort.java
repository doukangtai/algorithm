package learn.sort;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/09/30
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, -2, -6};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 先分，再合并
     * 思想：分治递归。
     * “分”：先通过mergeSort递归将array分成单个元素，
     * “治”：再通过merge将单个元素逐个按照顺序合并。
     * 步骤：通过mergeSort递归分成单个元素，在通过merge合并，
     * 从i = left和j = mid + 1开始按照谁小谁先入临时数组temp中，最后将temp中的数据赋值给原array数组
     * @param array
     * @param left
     * @param right
     * @param temp 临时数组
     */
    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid, temp);
        mergeSort(array, mid + 1, right, temp);
        merge(array, left, mid, right, temp);
    }

    /**
     * 合并操作
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }
        int arrayLeft = left;
        int tempLeft = 0;
        while (arrayLeft <= right) {
            array[arrayLeft++] = temp[tempLeft++];
        }
    }

}
