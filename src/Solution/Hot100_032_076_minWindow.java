package Solution;

public class Hot100_032_076_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {

        int[] cnt = new int[56];
        int[] need = new int[56];

        int m = t.length();
        for (int i = 0; i < m; i++) {
            need[get_key(t.charAt(i))]++;
        }

        int l = 0, r = 0;
        String res = "";
        while (r < s.length()){
            while (!check(cnt, need) && r < s.length()){
                cnt[get_key(s.charAt(r))] ++;
                r++;
            }
            if (res.equals("") && check(cnt, need)){
                res = s.substring(l, r);
            }
            while (check(cnt, need) && l < r){

                cnt[get_key(s.charAt(l))] --;
                l++;
            }
//            因为l是临界点右移退出的循环
            if (r-l+1 < res.length()){
                res = s.substring(l-1, r);
            }

        }


        return res;
    }

    public static boolean check(int[] cnt, int[] need){
//        是否为问题的一个解
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] < need [i]) return false;
        }
        return true;
    }

    public static int get_key(Character tmp){
        return tmp - 'A';
    }
}
