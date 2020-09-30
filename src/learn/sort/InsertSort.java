package learn.sort;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/09/29
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, -2, -6};
        insertSort(array);
    }

    /**
     * 思想：index = i处为待插入的数据，从index为0到i - 1中选择一个合适的位置插入这个数据
     * 步骤：从i = 1开始，在0到i - 1中寻找一个不满足numIndex >= 0 && num < array[numIndex]，
     * 将待插入的num进行array[numIndex + 1] = num;
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 待插入数据
            int num = array[i];
            // 带插入数据的前一个索引
            int numIndex = i - 1;
            while (numIndex >= 0 && num < array[numIndex]) {
                array[numIndex + 1] = array[numIndex];
                numIndex--;
            }
            if (numIndex + 1 != i) {
                array[numIndex + 1] = num;
            }
//            System.out.println("第" + i + "次排序后" + Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }

}
