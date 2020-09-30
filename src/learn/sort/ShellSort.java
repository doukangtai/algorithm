package learn.sort;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/09/29
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, -2, -6};
//        shellSort(array);
        shellSort2(array);
    }

    /**
     * 交换法
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        // 分组
        for (int group = array.length / 2; group > 0; group /= 2) {
            // 每个组进行插入排序，交换法
            for (int i = group; i < array.length; i++) {
                for (int j = i - group; j >= 0; j -= group) {
                    if (array[j + group] < array[j]) {
                        int temp = array[j + group];
                        array[j + group] = array[j];
                        array[j] = temp;
                    }
                }
            }
//            System.out.println("分组大小为" + group + "的排序结果" + Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 交换法 --> 移位法
     * 思想：先通过/2进行分组，按照每个不同的组，再进行插入排序
     * @param array
     */
    public static void shellSort2(int[] array) {
        // 分组
        for (int group = array.length / 2; group > 0; group /= 2) {
            // 每个组进行插入排序，移位法
            for (int i = group; i < array.length; i++) {
                int min = array[i];
                int minIndex = i - group;
                while (minIndex >= 0 && min < array[minIndex]) {
                    array[minIndex + group] = array[minIndex];
                    minIndex -= group;
                }
                if (minIndex + group != i) {
                    array[minIndex + group] = min;
                }
            }
//            System.out.println("分组大小为" + group + "的排序结果" + Arrays.toString(array));
        }
//        System.out.println(Arrays.toString(array));
    }

}
