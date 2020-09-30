package learn.sort;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/09/30
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, 2, 6};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 基数排序（桶排序）
     * 思想：从个位开始到最高位，逐位按顺序放置在0-9的桶中，再按顺序放回原数组array中，位数不够的用0补全
     * 步骤：获取最大数的位数，遍历maxLen次，
     * 将array中的数依次放在bucket中，同时在bucketElementCount中记录每个桶中元素的数量，
     * 最后将桶中的元素依次放回原数组array中，
     * 注意将bucketElementCount[j] = 0;否则出现array[tempIndex++]越界
     * @param array
     */
    public static void radixSort(int[] array) {
        int bucketNum = 10;
        int maxNum = array[0];
        for (int i = 1; i < array.length; i++) {
            maxNum = Math.max(maxNum, array[i]);
        }
        int maxLen = String.valueOf(maxNum).length();
        int[][] bucket = new int[bucketNum][array.length];
        int[] bucketElementCount = new int[bucketNum];
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < array.length; j++) {
                int digitOfElement = (int) (array[j] / Math.pow(10, i) % 10);
                bucket[digitOfElement][bucketElementCount[digitOfElement]++] = array[j];
            }
            int tempIndex = 0;
            for (int j = 0; j < bucketElementCount.length; j++) {
                if (bucketElementCount[j] != 0) {
                    for (int k = 0; k < bucketElementCount[j]; k++) {
                        array[tempIndex++] = bucket[j][k];
                    }
                }
                bucketElementCount[j] = 0;
            }
        }
    }

}
