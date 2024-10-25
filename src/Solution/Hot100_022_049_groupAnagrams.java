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
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] unorder_key = strs[i].toCharArray();
            Arrays.sort(unorder_key);
//            String order_key = String.valueOf(unorder_key);
            String order_key = new String(unorder_key);
            System.out.println("order_key: " + order_key);
            if (!map.containsKey(order_key)){
                map.put(order_key, new ArrayList<>());
            }
            map.get(order_key).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
