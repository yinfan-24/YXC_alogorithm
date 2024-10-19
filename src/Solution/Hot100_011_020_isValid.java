package Solution;

import java.util.Stack;

public class Hot100_011_020_isValid {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char op = s.charAt(i);
            if (op == '(' || op == '[' || op == '{'){
                stack.push(op);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                if (stack.peek() == '(' && op == ')'){
                    stack.pop();
                } else if (stack.peek() == '[' && op == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && op == '}') {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
