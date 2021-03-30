package leetcode.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2021/03/30
 * 百度：DP
 */
public class Question1 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        if (n <= 1) {
            System.out.println(0);
            return;
        }
        char[] arr = str.toCharArray();
        ArrayList<Integer>[] listArr = new ArrayList[10];
        for (int i = 0; i < arr.length; i++) {
            if (listArr[arr[i] - '0'] == null) {
                listArr[arr[i] - '0'] = new ArrayList<>();
            }
            listArr[arr[i] - '0'].add(i);
        }
        dp = new int[arr.length];
        dp[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            int index = getIndex(listArr, arr[i], i);
            if (index == -1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, dp[index] + 1);
            }
        }
        System.out.println(dp[arr.length - 1]);
    }

    private static int getIndex(ArrayList<Integer>[] listArr, char c, int index) {
        ArrayList<Integer> list = listArr[c - '0'];
        int maxIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Integer tempIndex = list.get(i);
            if (tempIndex < index) {
                if (dp[tempIndex] < min) {
                    maxIndex = tempIndex;
                    min = dp[tempIndex];
                }
            } else {
                return maxIndex;
            }
        }
        return maxIndex;
    }
}
