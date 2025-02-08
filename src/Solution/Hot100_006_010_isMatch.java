package Solution;

public class Hot100_006_010_isMatch {
    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        System.out.println(isMatch(s, p));
    }
    public static boolean isMatch(String s, String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        dp[0][0] = true;
        for (int j = 1; j < p.length(); j++) {
            if (pc[j-1] == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (sc[i-1] == pc[j-1] || pc[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                } else if (pc[j-1] == '*') {
                    if (pc[j-2] == sc[i-1] || pc[j-2] == '.'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
//    public static boolean isMatch(String s, String p) {
//        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//        char[] cs = s.toCharArray();
//        char[] cp = p.toCharArray();
//
//        dp[0][0] = true;
////        dp[i][j]代表 s 的0至i-1 是否与 p 的 0至j-1 匹配
//        for (int j = 1; j <= cp.length; j++) {
//            if (cp[j-1] == '*'){
//                dp[0][j] = dp[0][j-2];
//            }
//        }
//
//        for (int i = 1; i <= cs.length; i++) {
//            for (int j = 1; j <= cp.length; j++) {
//                if (cs[i-1] == cp[j-1] || cp[j-1] == '.'){
////                    两个字符串从前往后进行比较
////                    最后一个字符匹配上的情况
//                    dp[i][j] = dp[i-1][j-1];
//                } else if (cp[j-1] == '*') {
////                    1、如果星号前面的字符能够匹配
//                    if (cp[j-2] == cs[i-1] || cp[j-2] == '.'){
////                        匹配s的后部或匹配0次
//                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
//                    }
////                    2、如果星号前面的字符无法匹配
//                    else {
//                        dp[i][j] = dp[i][j-2];
//                    }
//                }
//            }
//        }
//
//        return dp[s.length()][p.length()];
//    }
}
