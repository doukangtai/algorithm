package leetcode.sandaoqvjianwenti.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/29
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] merge = new MergeIntervals()
                .merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        List<int[]> resList = new ArrayList<>();
        resList.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] last = resList.get(resList.size() - 1);
            if (last[1] >= interval[0]) {
                last[1] = Math.max(last[1], interval[1]);
            } else {
                resList.add(new int[]{interval[0], interval[1]});
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
