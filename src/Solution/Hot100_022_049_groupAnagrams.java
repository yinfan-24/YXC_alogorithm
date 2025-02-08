package Solution;

import java.util.*;

public class Hot100_022_049_groupAnagrams {

    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        String[] strs = {"abc", "bca", "bde", "def", "cab"};
        ans = groupAnagrams(strs);
        for (List<String> list : ans) {
            System.out.println(list);
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs){
            String code = encode(s);
            map.putIfAbsent(code, new LinkedList<>());
            map.get(code).add(s);
        }

        List<List<String>> res = new LinkedList<>();
        for (List<String> v : map.values()){
            res.add(v);
        }
        return res;
    }

    static String encode(String s){
        char[] cnt = new char[26];
        for(char c : s.toCharArray()){
            int index = c - 'a';
            cnt[index]++;
        }
        return new String(cnt);
    }

}
