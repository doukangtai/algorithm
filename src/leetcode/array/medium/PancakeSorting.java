package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class PancakeSorting {
    public static void main(String[] args) {
        System.out.println(new PancakeSorting().pancakeSort(new int[]{3, 2, 4, 1}));
    }

    List<Integer> res;

    public List<Integer> pancakeSort(int[] arr) {
        res = new ArrayList<>();
        help(arr, arr.length);
        return res;
    }

    public void help(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        reverse(arr, maxIndex);
        res.add(maxIndex + 1);
        reverse(arr, n - 1);
        res.add(n);
        help(arr, n - 1);
    }

    public void reverse(int[] arr, int j) {
        int i = 0;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
