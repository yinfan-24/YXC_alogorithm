package Solution;

public class Hot100_005_005_longestPalindrome {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
//            奇回文
            int l = i-1;
            int r = i+1;
            if (ans.length() == 0) ans = s.substring(i, i+1);
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if (ans.length() < r-l+1){
                    ans = s.substring(l, r+1);
                }
                l --;
                r ++;
            }
//            偶回文
            l = i;
            r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if (ans.length() < r-l+1){
                    ans = s.substring(l, r+1);
//                    System.out.println(l + " " + r);
                }
                l --;
                r ++;
            }


        }
        return ans;
    }
}
