package Solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hot100_052_139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> map = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && map.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
