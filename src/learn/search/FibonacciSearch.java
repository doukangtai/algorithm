package learn.search;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/10/01
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        int[] array = {-5, -3, -1, 3, 3, 3, 6, 6, 6, 9};
        int i = fibonacciSearch(array, 3);
        System.out.println(i);
    }

    /**
     * 非递归
     * 斐波那契数列公式：i >= 2,f[i] = f[i - 1] + f[i - 2]
     * 变形：f[i] - 1 = (f[i - 1] - 1) + (f[i - 2] - 1) + 1
     * 思想：将待查找数组按照斐波那契数列进行分组，
     * 总长度：f[i] - 1
     * 左部分：f[i - 1] - 1
     * 右部分：f[i - 2] - 1
     * 中间值：left + f[i - 1] - 1
     * 由于array可能比f[i] - 1小，所以需要扩容，末尾多出来的用array中最大值填充，
     * mid的值：left + f[i - 1] - 1
     * 再通过控制left、right、k的值，让array按照斐波那契数列分割，
     * 直到找到value，
     * 如果找到的mid（array的index）>= array.length，说明mid为扩容部分，应返回right的值，
     * 否则返回mid，
     * while结束没返回，说明此时没找到，应该return -1;
     * @param array
     * @param value
     * @return
     */
    public static int fibonacciSearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        int[] fibonacci = getFibonacci(20);
        int k = 0;
        while (array.length > fibonacci[k] - 1) {
            k++;
        }
        int[] newArray = Arrays.copyOf(array, fibonacci[k] - 1);
        for (int i = right + 1; i < newArray.length; i++) {
            newArray[i] = array[right];
        }
        while (left <= right) {
            int mid = left + fibonacci[k - 1] - 1;
            if (value < newArray[mid]) {
                right = mid - 1;
                k--;
            } else if (value > newArray[mid]) {
                left = mid + 1;
                k -= 2;
            } else {
                if (mid >= array.length) {
                    return right;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 非递归生成斐波那契数列
     * @param size
     * @return
     */
    public static int[] getFibonacci(int size) {
        int[] array = new int[size];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

}
