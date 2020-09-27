package learn.recursion;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/09/27
 */
public class EightQueens {

    private static int max = 8;

    private static int[] array = new int[max];

    private static int count = 0;

    private static int judgeCount = 0;

    private static int checkCount = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println("可能性：" + count);
        System.out.println("判断次数：" + judgeCount);
        System.out.println("checkCount：" + checkCount);
    }

    public static void check(int n) {
        checkCount++;
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public static boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        count++;
        System.out.println(Arrays.toString(array));
    }

}
