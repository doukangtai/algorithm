package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2021/01/04
 */
public class CountServersThatCommunicate {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0, 0}
                , {0, 0, 1, 0}
                , {0, 0, 1, 0}
                , {0, 0, 0, 1}};
        System.out.println(new CountServersThatCommunicate().countServers(grid));
    }

//    public int countServers(int[][] grid) {
//        int[][] tempArr = new int[grid.length][grid[0].length];
//        int countSum = 0;
//        for (int i = 0; i < grid.length; i++) {
//            int count = 0;
//            int x = -1;
//            int y = -1;
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 1) {
//                    count++;
//                    if (count <= 1) {
//                        x = i;
//                        y = j;
//                    } else {
//                        tempArr[x][y] = 1;
//                        tempArr[i][j] = 1;
//                    }
//                }
//            }
//            countSum = count >= 2 ? countSum + count : countSum;
//        }
//        for (int i = 0; i < grid[0].length; i++) {
//            int count = 0;
//            int countRepeat = 0;
//            for (int j = 0; j < grid.length; j++) {
//                if (grid[j][i] == 1) {
//                    count++;
//                    if (tempArr[j][i] == 1) {
//                        countRepeat++;
//                    }
//                }
//            }
//            if (count >= 2) {
//                count -= countRepeat;
//                countSum += count;
//            }
//        }
//        return countSum;
//    }

    public int countServers(int[][] grid) {
        int sum = 0;
        int[] xCount = new int[grid.length];
        int[] yCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    xCount[i]++;
                    yCount[j]++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && (xCount[i] > 1 || yCount[j] > 1)) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
