package Solution;

public class Hot100_045_121_maxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        int cur_min = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            cur_min = Math.min(cur_min, prices[i]);
            res = Math.max(res, prices[i] - cur_min);
        }
        return res;
    }
}
