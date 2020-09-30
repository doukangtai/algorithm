package learn.sort;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/09/29
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, -2, -6};
        selectSort(array);
    }

    /**
     * 思想：先假设最前面的数为最小值，与后面的所有数比较选择一个最小的放在最前面，
     * 循环array.length - 1次
     * 步骤：假设minIndex = i处为最小值，与i + 1到array.length的值比较，
     * 找出最小值放在i处，循环array.length - 1遍，得到有序数组
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 假设i为最小数索引
            int minIndex = i;
            int min = array[minIndex];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    minIndex = j;
                    min = array[minIndex];
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
//            System.out.println("第" + (i + 1) + "次排序后" + Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }

}
