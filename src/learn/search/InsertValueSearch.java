package learn.search;

/**
 * @author 窦康泰
 * @date 2020/10/01
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int i = insertValueSearch(array, 0, array.length - 1, 4);
        System.out.println(i);
    }

    /**
     * 思路：在二分查找的思想上，通过将value添加进mid的计算公式中，按照value在array中值大小的比例，
     * 确定mid的值，更适合于array中值分布均匀的查找，
     * 不均匀查找效率不一定比BinarySearch高
     * @param array
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int insertValueSearch(int[] array, int left, int right, int value) {
        // value < array[left] || value > array[right]
        // 防止在value的值很大时mid会随着变的很大，出现array[mid]越界
        if (left > right || value < array[left] || value > array[right]) {
            return -1;
        }
        int mid = left + (value - array[left]) / (array[right] - array[left]) * (right - left);
        if (value == array[mid]) {
            return mid;
        } else if (value > array[mid]) {
            return insertValueSearch(array, mid + 1, right, value);
        } else {
            return insertValueSearch(array, left, mid - 1, value);
        }
    }

}
