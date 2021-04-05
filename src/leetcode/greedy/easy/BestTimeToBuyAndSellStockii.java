package leetcode.greedy.easy;

/**
 * @author 窦康泰
 * @date 2021/04/05
 */
public class BestTimeToBuyAndSellStockii {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
