package Solution;

public class Hot100_032_076_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()){
            return "";
        }

        int[] cnt = new int[128];
        int n = s.length(), remainChar = 0;
        for (char c: t.toCharArray()){
            if (cnt[c] == 0) remainChar++;
            cnt[c]++;
        }

        int resLeft = -1, resRight = n;
        char[] sArray = s.toCharArray();
        for (int l = 0, r = 0; r < n; r++) {
            char c = sArray[r];
            cnt[c]--;
            if (cnt[c] == 0) remainChar--;

//            左移l的操作
            while (remainChar == 0 && l < n){
                if (r-l < resRight-resLeft){
                    resRight = r;
                    resLeft = l;
                }
                char k = sArray[l++];
                cnt[k]++;
                if (cnt[k] > 0) remainChar++;
            }
        }

        return resRight == n ? "" : s.substring(resLeft, resRight+1);
    }
}
