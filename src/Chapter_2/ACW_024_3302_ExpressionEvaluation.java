package Chapter_2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static jdk.nashorn.internal.objects.NativeArray.map;

public class ACW_024_3302_ExpressionEvaluation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        String s = reader.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                int x = 0, j = i;
                while (Character.isDigit(s.charAt(j)) && j < s.length()){
                    x = 10 * x + s.charAt(j) - '0';
                    j++;
                }
                num.push(x);
                i = j - 1;
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek()!='(') eval(op, num);
                op.pop();
            }else {
                while (!op.empty() && map.get(op.peek()) >= map.get(c) && op.peek() != '(' ){
                    eval(op, num);
                }
                op.push(c);
            }
        }
        while (!op.empty()) eval(op, num);
        writer.write(num.peek() + "");
        reader.close();
        writer.flush();
        writer.close();
    }

    public static void eval(Stack<Character> op, Stack<Integer> num){
        int b = num.pop();
        int a = num.pop();

        char c = op.pop();
        if (c == '+'){
            num.push(a + b);
        } else if (c == '-') {
            num.push(a - b);
        } else if (c == '*') {
            num.push(a * b);
        } else {
            num.push(a / b);
        }
    }

}


/*
(2+2)*(1+1)
 */