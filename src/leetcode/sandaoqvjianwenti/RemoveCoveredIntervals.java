package leetcode.sandaoqvjianwenti;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/01/29
 */
public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        System.out.println(new RemoveCoveredIntervals()
                .removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}}));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (left <= interval[0] && right >= interval[1]) {
                res++;
            } else if (right >= interval[0] && right <= interval[1]) {
                left = interval[0];
                right = interval[1];
            } else if (right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - res;
    }
}
