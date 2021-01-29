package leetcode.sandaoqvjianwenti.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/29
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> resList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0];
            int a2 = firstList[i][1];
            int b1 = secondList[j][0];
            int b2 = secondList[j][1];
            if (!(a2 < b1 || b2 < a1)) {
                int left = Math.max(a1, b1);
                int right = Math.min(a2, b2);
                resList.add(new int[]{left, right});
            }
            if (a2 < b2) {
                i++;
            } else {
                j++;
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
