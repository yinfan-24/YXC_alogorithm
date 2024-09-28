package Chapter_2;

import java.io.*;
import java.util.Stack;

public class ACW_026_830_MonotoneStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l = reader.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(l[0]);
        String[] l_num = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(l_num[i]);
            while (!stack.empty() && stack.peek() >= num) stack.pop();
            if (stack.empty()) writer.write("-1 ");
            else writer.write(stack.peek() + " ");
            stack.push(num);
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}

/*
10
11 27 11 6 14 26 8 22 13 7

维护一个栈低小，栈头大的单调栈
入栈的条件：栈空、栈顶比当前元素小

ans:
-1 11 -1 -1 6 14 6 8 8 6

 */