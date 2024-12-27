package Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hot100_094_301_removeInvalidParentheses {
    Set<String> set= new HashSet<>();
    int n, max, len;
    String s;
    public List<String> removeInvalidParentheses(String _s) {
        s = _s;
        n = s.length();
        int l = 0, r = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') l++;
            else if (c == ')') r++;
        }
        max = Math.max(l, r);
        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    void dfs(int u, String cur, int score){
//        u 为枚举到的索引
//        cur 为当前已经枚举得到的字符串
//        score 为得分情况，左括号得分+1，右括号得分-1
//        符合要求的字符串一定是得分为0的，且枚举过程中不会出现得分为负
        if (score < 0 || score > max) return;
        if (u == n){
//            已经枚举到原始字符串的最后一个位置了，得到可能结果
//            1、左右括号匹配
//            2、当前结果串比先前的结果串，长度相等或者更长
            if (score == 0 && cur.length() >= len){
//                这里是为了保证候选结果是最长字串
                if (cur.length() > len) set.clear();
                len = cur.length();
                set.add(cur);
            }
            return;
        }
        char c = s.charAt(u);
        if (c == '('){
            dfs(u+1, cur + String.valueOf(c), score + 1);
            dfs(u+1, cur, score);
        } else if (c == ')') {
            dfs(u+1, cur + String.valueOf(c), score - 1);
            dfs(u+1, cur, score);
        } else {
            dfs(u+1, cur + String.valueOf(c), score);
        }
    }
}
