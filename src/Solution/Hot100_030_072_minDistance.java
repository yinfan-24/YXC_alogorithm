package Solution;

public class Hot100_030_072_minDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n*m == 0) return n + m;

//        dp[i][j]代表word1的0~i，转移到word2的0~j需要的最小步数
        int[][] dp = new int[n+1][m+1];

//        初始化
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    dp[i+1][j+1] = 1 + Math.min(Math.min(dp[i][j+1], dp[i][j]), dp[i+1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
