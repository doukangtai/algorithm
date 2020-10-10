package learn.search.binarysearchnorecursion;

/**
 * @author 窦康泰
 * @date 2020/10/09
 */
public class BinarySearchNoRecursion {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        int index = binarySearch(array, 10);
        System.out.println(index);
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
