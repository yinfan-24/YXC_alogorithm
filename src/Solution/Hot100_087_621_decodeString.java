package Solution;

import java.util.Deque;
import java.util.LinkedList;

public class Hot100_087_621_decodeString {
    public static void main(String[] args) {
//        String s = "2[abc]3[cd]ef";
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
        String s = "100[leetcode]";
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {
        Deque<Integer> int_buffer = new LinkedList<>();
        Deque<Character> char_buffer = new LinkedList<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(s.charAt(i))){
                StringBuilder numericStringBuilder = new StringBuilder();
                numericStringBuilder.append(s.charAt(i));
                while (Character.isDigit(s.charAt(i + 1))){
                    numericStringBuilder.append(s.charAt(i+1));
                    i++;
                }
//                System.out.println(numericStringBuilder.toString());
                int_buffer.push(Integer.parseInt(numericStringBuilder.toString()));
            }
            else if(cur == '[') char_buffer.push(cur);
            else if (cur == ']') {
                int times = int_buffer.pop();
                StringBuilder sb = new StringBuilder();
                while (char_buffer.peek() != '['){
                    sb.append(char_buffer.pop());
                }
                char_buffer.pop(); // 移除左括号
                sb.reverse();
                while (times-- > 0){
                    for (int j = 0; j < sb.length(); j++) {
                        char_buffer.push(sb.charAt(j));
                    }
                }
            }
            else {
                char_buffer.push(cur);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!char_buffer.isEmpty()) res.append(char_buffer.pop());
        res.reverse();
        return res.toString();
    }
}
