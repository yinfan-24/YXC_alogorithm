package Solution;

public class Hot100_088_309_maxProfit {
    public int maxProfit(int[] prices) {
//        0 目前持有股票
//        1 处于冷冻期
//        2 不持有股票，不处于冷冻期
//        操作：状态由前一天的转移
//        不操作：状态等于前一天的操作
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length ; i++) {
            dp[i][0] = Math.max(dp[i-1][2] - prices[i], dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][1], dp[prices.length-1][2]);
    }
}
