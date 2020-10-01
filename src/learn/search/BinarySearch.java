package learn.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2020/10/01
 */
public class BinarySearch {

    public static void main(String[] args) {
//        testBinarySearch();
        testBinarySearch2();
    }

    public static void testBinarySearch() {
        int[] array = {-5, -3, -1, 3, 6, 9};
        int i = binarySearch(array, 0, array.length - 1, -1);
        System.out.println(i);
    }

    public static void testBinarySearch2() {
        int[] array = {-5, -3, -1, 3, 3, 3, 3, 3, 6, 9};
        List<Integer> binarySearch2 = binarySearch2(array, 0, array.length - 1, 3);
        System.out.println(binarySearch2);
    }

    /**
     * 二分查找value的单个索引
     * 思路：取数组中间数与待查找value比较，
     * 若相等则返回mid，
     * 若array[mid] < value则向右侧递归，
     * 否则向左递归，
     * 注意递归结束条件left > right
     * @param array
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] < value) {
            return binarySearch(array, mid + 1, right, value);
        } else {
            return binarySearch(array, left, mid - 1, value);
        }
    }

    /**
     * 二分查找value的多个索引添加进list中
     * 思路：在binarySearch的基础上，在array[mid] == value时，将mid添加进list中，
     * temp = mid - 1;向左继续判断，相等则将index添加进list中
     * temp = mid + 1;向右。。。
     * @param array
     * @param left
     * @param right
     * @param value
     */
    public static List<Integer> binarySearch2(int[] array, int left, int right, int value) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        if (array[mid] == value) {
            List<Integer> indexList = new ArrayList<>();
            indexList.add(mid);
            int temp = mid - 1;
            while (temp >= 0 && array[temp] == value) {
                indexList.add(temp--);
            }
            temp = mid + 1;
            while (temp <= array.length - 1 && array[temp] == value) {
                indexList.add(temp++);
            }
            return indexList;
        } else if (array[mid] < value) {
            return binarySearch2(array, mid + 1, right, value);
        } else {
            return binarySearch2(array, left, mid - 1, value);
        }
    }

}
