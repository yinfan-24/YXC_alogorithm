package Solution;

import java.util.Arrays;

public class Hot100_092_621_leastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            hash[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(hash);
        int minLen = (n+1) * (hash[25]-1) + 1;
        for (int i = 24; i >=0 ; i--) {
            if (hash[25] == hash[i]) minLen ++;
        }

        return Math.max(minLen, tasks.length);
    }
}
