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

        Map<String, String> map = new HashMap<String, String>(){
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
        backTrack(digits, map, 0, new StringBuilder());
        return res;
    }

    static void backTrack(String digits, Map<String, String> map, int index, StringBuilder sb){
        res.clear();

//        判断回溯
        if (sb.length() == digits.length()){
            if (!sb.toString().isEmpty()){
                res.add(new StringBuilder(sb).toString());
            }
            return;
        }
        String cur = digits.substring(index, index+1);
        for (int i = 0; i < map.get(cur).length(); i++) {
            sb.append(map.get(cur).charAt(i));
            backTrack(digits, map, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
