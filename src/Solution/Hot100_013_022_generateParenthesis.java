package Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Hot100_013_022_generateParenthesis {
    static List<String> res = new LinkedList<>();
    public static List<String> generateParenthesis(int n) {
        res.clear();
        traceBack(n, 0, 0, new StringBuilder());
        return res;
    }

    public static void traceBack(int n, int left, int right, StringBuilder sb){
        if (left == n && right == n){
            res.add(sb.toString());
            return;
        }

//        添加左括号
        if (left < n){
            sb.append('(');
            traceBack(n, left+1, right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
//        添加右括号
        if (right < left){
            sb.append(')');
            traceBack(n, left, right+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
