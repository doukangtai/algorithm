package template.sort;

/**
 * @Author 窦康泰
 * @Date 2020-07-17 13:39
 */
public class Search {

    /**
     * 二分查找
     *
     * @param arr
     * @param key
     */
    static int binarySearch(int[] arr, int key) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (arr[M] == key) {
                return M;
            } else if (arr[M] > key) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找，第一个等于key
     *
     * @param arr
     * @param key
     */
    static int binarySearchFirstEqual(int[] arr, int key) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (arr[M] >= key) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        if (key == arr[L] && L < arr.length) {
            return L;
        }
        return -1;
    }

    /**
     * 二分查找，第一个大于等于key
     *
     * @param arr
     * @param key
     */
    static int binarySearchFirstLargeEqual(int[] arr, int key) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (arr[M] >= key) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return L;
    }

    /**
     * 二分查找，第一个大于key
     *
     * @param arr
     * @param key
     */
    static int binarySearchFirstLarge(int[] arr, int key) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (arr[M] > key) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return L;
    }

    /**
     * 二分查找，最后一个等于key
     *
     * @param arr
     * @param key
     */
    static int binarySearchLastEqual(int[] arr, int key) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (arr[M] <= key) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        if (R >= 0 && key == arr[R]) {
            return R;
        }
        return -1;
    }

    /**
     * 二分查找，最后一个小于等于key
     *
     * @param arr
     * @param key
     */
    static int binarySearchLastSmallEqual(int[] arr, int key) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (arr[M] <= key) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return R;
    }

    /**
     * 二分查找，最后一个小于key
     *
     * @param arr
     * @param key
     */
    static int binarySearchLastSmall(int[] arr, int key) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (arr[M] < key) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return R;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 8};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8};
//        int search = binarySearch(array1, 5);
        int i = binarySearchLastSmall(array1, 4);
        System.out.println(i);
    }

}
