package Solution;

import static java.lang.Math.max;

public class Hot100_002_003_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int l = 0;
        int r = 0;
        int res = 0;
        int[] already = new int[26];
        for (int i = 0; i < 26; i++) already[i] = 0;
        already[s.charAt(0) - 'a'] += 1;
//        r ++;
        int max_idx = s.length() - 1;
        while (r < max_idx){
//            获取下一位的索引
            int u = s.charAt(r + 1) - 'a';
//            如果下一位在字典里出现过
            if (already[u] != 0){
                already[s.charAt(l) - 'a'] -= 1;
                l ++;
            }else {
                r ++;
                already[s.charAt(r) - 'a'] += 1;
            }
            res = max(res, r - l + 1);
        }
        return res;
    }
}
