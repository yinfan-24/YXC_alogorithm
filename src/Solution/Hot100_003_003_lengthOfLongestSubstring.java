package Solution;

import java.util.HashMap;

import static java.lang.Math.max;

public class Hot100_003_003_lengthOfLongestSubstring {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] char_map = new int[129];
        int res = 0;
        int fast = 0, slow = 0;
        while (fast < s.length()){
            int c = s.charAt(fast) - ' ';
            if (char_map[c] == 0){
                char_map[c]++;
                fast++;
            } else {
                char_map[s.charAt(slow) - ' '] --;
                slow++;
            }
            res = Math.max(res, fast - slow);
        }
        return res;
    }
}
