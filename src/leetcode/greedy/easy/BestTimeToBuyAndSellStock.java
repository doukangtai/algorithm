package leetcode.greedy.easy;

/**
 * @author 窦康泰
 * @date 2021/04/05
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(prices[i] - min, res);
            }
        }
        return res;
    }
}
