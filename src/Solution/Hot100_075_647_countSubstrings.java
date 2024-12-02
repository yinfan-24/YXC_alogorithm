package Solution;

public class Hot100_075_647_countSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = n;
//        dp[i][j] 代表第i个字符代表第i个字符到第j个字符能否组成回文字符串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (j == i+1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) res ++;

            }
        }
        return res;
    }
}
