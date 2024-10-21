package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hot100_013_022_generateParenthesis {
    static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        res.clear();
        traceBack(n, 0, 0, new StringBuilder());
        return res;
    }

    public static void traceBack(int n, int left, int right, StringBuilder sb){
//       返回符合的组合
        if (left == n && right == n){
            res.add(sb.toString());
            return;
        }
        if (left < n){
//            添加左括号的条件：左括号数量小于n
            sb.append('(');
            traceBack(n, left+1, right+1, sb);
//            回溯
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left){
//              添加右括号的条件：左括号大于右括号
            sb.append(')');
            traceBack(n, left, right+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }



    }
}
