package Solution;

public class Hot100_095_032_longestValidParentheses {
    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == ')'){
                if (arr[i-1] == '('){
                    if (i >= 2) dp[i] += dp[i-2];
                    dp[i] += 2;
                } else {
//                    arr[i-1] == ')'
                    if (i - dp[i-1] - 1 >= 0){
                        if (arr[i - dp[i-1] - 1] == '('){
                            dp[i] += dp[i-1] + 2;
                            if (i-dp[i-1]-2 >= 0) dp[i] += dp[i-dp[i-1]-2];
                        }
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
