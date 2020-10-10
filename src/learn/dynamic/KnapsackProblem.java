package learn.dynamic;

/**
 * 01背包问题：放不重复的物品
 * @author 窦康泰
 * @date 2020/10/09
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        // 物品重量
        int[] weight = {1, 4, 3};
        // 物品价值
        int[] value = {1500, 3000, 2000};
        // 背包容量
        int m = 4;
        // 物品数量
        int n = weight.length;
        // 前i个商品中能够装入j重量的商品的最大价值
        int[][] v = new int[n + 1][m + 1];
        // 记录什么时候向背包放入了物品
        int[][] path = new int[n + 1][m + 1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (weight[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    // v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - weight[i - 1]]);
                    if (v[i - 1][j] < value[i - 1] + v[i - 1][j - weight[i - 1]]) {
                        v[i][j] = value[i - 1] + v[i - 1][j - weight[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.printf("%6d", v[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println();
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("将第" + i + "个物品放入了背包");
                j -= weight[i - 1];
            }
            i--;
        }
    }

}
