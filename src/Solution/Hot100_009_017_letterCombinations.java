package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hot100_009_017_letterCombinations {

    public static void main(String[] args) {
        String s = "";
        List<String> ans = letterCombinations(s);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    public static List<String> res = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        res.clear();
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        backTrack(digits, map, 0, new StringBuilder());
        return res;
    }

    public static void backTrack(String digit, HashMap<String, String> map, int idx, StringBuilder sb){
        if (sb.length() == digit.length()){
            if (!sb.toString().isEmpty()){
                res.add(sb.toString());
            }
            return;
        }

        String cur = digit.substring(idx, idx+1);
        for (int i = 0; i < map.get(cur).length(); i++) {
            sb.append(map.get(cur).charAt(i));
            backTrack(digit, map, idx+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
