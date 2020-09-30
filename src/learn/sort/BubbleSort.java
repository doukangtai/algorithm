package learn.sort;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/09/28
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, -2, -6};
        bubbleSort(array);
    }

    /**
     * 思想：从index = 0开始，两两比较，将较大的数放在后面，每一遍循环最后一个数是最大的，
     * 共需要循环array.length - 1次
     * 步骤：每次从index = 0开始，比较array[j]和array[j + 1],直到array.length - 1 - i为止，
     * 将两数中较大的排在后面，循环array.length - 1次，得到有序数组
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
//            System.out.println("第" + (i + 1) + "次排序后" + Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }

}
