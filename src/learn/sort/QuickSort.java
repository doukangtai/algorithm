package learn.sort;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/09/30
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, -2, -6};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 思想：假设选择key = array[l];最为参照，将大于等于key的数放在右边，将小于等于key的数放在左边，
     * 通过递归调用，空间换时间，注意left >= right条件终止递归调用，防止死循环
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int key = array[l];
        while (l < r) {
            while (l < r && array[r] >= key) {
                r--;
            }
            array[l] = array[r];
            while (l < r && array[l] <= key) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = key;
        quickSort(array, left, r - 1);
        quickSort(array, r + 1, right);
    }

}
