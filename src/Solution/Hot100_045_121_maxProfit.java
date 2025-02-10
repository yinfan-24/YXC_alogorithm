package Solution;

public class Hot100_045_121_maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int res = 0;
        int curMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            res = Math.max(res, prices[i] - curMin);
        }
        return res;
    }
}
