package Solution;

import java.util.Stack;

public class Hot100_011_020_isValid {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        char[] sc = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = sc[i];
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.peek() == '(') stack.pop();
                else if (c == ']' && stack.peek() == '[') stack.pop();
                else if (c == '}' && stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
