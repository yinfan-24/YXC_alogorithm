package Solution;

public class Hot100_006_010_isMatch {
    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//        从右往左扫描
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        dp[0][0] = true;
//        dp[i][j]代表 s 的第 0 个字符到第 i-1 个字符，是否于 p 的第 0 个字符到第 j-1 个字符匹配

//        s为空，p不为空；j=1代表从第1个字符开始匹配
        for (int j = 1; j <= cp.length ; j++) {
            if (cp[j-1] == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }

//        开始dp的状态转移部分
        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length ; j++) {
//                末尾的能匹配上
                if (cs[ i-1 ] == cp[ j-1 ] || cp[ j-1 ] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                } else if (cp[j-1] == '*') {
//                末尾如果是 *，可以继续分情况讨论
//                    -- 如果 * 的前一位能够匹配上
                    if (cs[ i-1 ] == cp[ j-2 ] || cp[ j-2 ] == '.'){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    } else {
//                    -- 如果 * 的前一位匹配不上，星号一定是 0 次
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
