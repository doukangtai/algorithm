package leetcode.greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 窦康泰
 * @date 2021/03/25
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                res++;
                end = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
