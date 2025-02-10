package Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hot100_052_139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo, wordDict);
    }

    private static boolean dfs(String s, int index, int[] memo, List<String> wordDict){
        if (index == s.length()) return true;
        if (memo[index] != -1) return memo[index] == 1;
        for (String word: wordDict){
            if (s.startsWith(word, index) && dfs(s, index+word.length(), memo, wordDict)){
                memo[index] = 1;
                return true;
            }
        }
        memo[index] = 0;
        return memo[0] == 1;
    }
}
