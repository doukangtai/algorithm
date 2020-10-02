package learn.tree;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/10/02
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, -2, -6};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 思路：通过array.length / 2 - 1找到第一个非叶子节点，
     * 逆序将二叉树调整成大顶堆，
     * 然后交换array[0]和最后一个非交换过去的节点，重新调整交换过节点的前面所有节点成为大顶堆，
     * 直到循环结束
     * @param array
     */
    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustHeap(array, 0, i);
        }
    }

    /**
     * 调整成大顶堆
     * 只能调整左右节点都是叶子结点的树，
     * 或者调整大顶堆的根节点
     * @param array
     * @param index
     * @param length
     */
    public static void adjustHeap(int[] array, int index, int length) {
        int temp = array[index];
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            // 注意i + 1 < length否则出问题
            if (i + 1 < length && array[i] < array[i + 1]) {
                i++;
            }
            if (array[i] > temp) {
                array[index] = array[i];
                index = i;
            } else {
                break;
            }
        }
        array[index] = temp;
    }

}
