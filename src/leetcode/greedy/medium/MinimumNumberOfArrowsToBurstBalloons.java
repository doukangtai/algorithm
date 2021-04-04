package leetcode.greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 窦康泰
 * @date 2021/03/25
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        }

        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) {
                return 0;
            }
            Arrays.sort(points, (o1, o2) -> {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            });
            int res = 1;
            int end = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (end < points[i][0]) {
                    end = points[i][1];
                    res++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int res = points.length;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                res--;
            } else {
                end = points[i][1];
            }
        }
        return res;
    }
}
